package com.productservice.product_service.service;

import com.netguides.base_domains.base_domains.records.CreateStockRequest;
import com.netguides.base_domains.base_domains.records.ProductStockResponse;
import com.productservice.product_service.controller.ProductController;
import com.productservice.product_service.feign.StockServiceFeign;
import com.productservice.product_service.records.CreateProductRequest;
import com.productservice.product_service.entity.ProductEntity;
import com.productservice.product_service.repository.ProductRepository;
import com.productservice.product_service.utils.ProductUtils;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final StockServiceFeign stockServiceFeign;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);


    public ProductService(ProductRepository productRepository, StockServiceFeign stockServiceFeign){
        this.productRepository = productRepository;
        this.stockServiceFeign = stockServiceFeign;
    }

    public CreateProductRequest createProduct(CreateProductRequest product){
        ProductEntity productEntity = ProductUtils.convertToEntity(product);
        ProductEntity savedEntity = this.productRepository.save(productEntity);
        CreateStockRequest request = ProductUtils.createStockRequestObj(savedEntity,product);
        stockServiceFeign.createInitialStock(request);
        return ProductUtils.convertToDto(savedEntity);
    }

    @CircuitBreaker(name="stock-get_product",fallbackMethod = "getProductInventoryFallBack")
    public ProductStockResponse getProductStock(Long productId){
        return stockServiceFeign.getProductStockQuantity(productId);
    }
    public ProductStockResponse getProductInventoryFallBack(Long productId,Exception ex){
        logger.info("Stock service is unavailable");
        return ProductStockResponse.builder().message("Stock Service is not Available").build();
    }
}
