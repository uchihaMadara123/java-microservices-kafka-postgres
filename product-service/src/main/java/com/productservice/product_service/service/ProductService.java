package com.productservice.product_service.service;

import com.productservice.product_service.records.CreateProductRequest;
import com.productservice.product_service.entity.ProductEntity;
import com.productservice.product_service.repository.ProductRepository;
import com.productservice.product_service.utils.ProductUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public CreateProductRequest createProduct(CreateProductRequest product){
        ProductEntity productEntity = ProductUtils.convertToEntity(product);
        return ProductUtils.convertToDto(this.productRepository.save(productEntity));
    }
}
