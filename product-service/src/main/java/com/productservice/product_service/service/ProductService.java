package com.productservice.product_service.service;

import com.netguides.base_domains.base_domains.records.CreateStockRequest;
import com.netguides.base_domains.base_domains.records.ProductStockResponse;
import com.productservice.product_service.feign.StockServiceFeign;
import com.productservice.product_service.records.CreateProductRequest;
import com.productservice.product_service.entity.ProductEntity;
import com.productservice.product_service.repository.ProductRepository;
import com.productservice.product_service.utils.ProductUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final StockServiceFeign stockServiceFeign;


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

    public ProductStockResponse getProductStock(Long productId){
        return stockServiceFeign.getProductStockQuantity(productId);
    }
}
