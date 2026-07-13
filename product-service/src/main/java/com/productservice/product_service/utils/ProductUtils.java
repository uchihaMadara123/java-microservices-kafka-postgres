package com.productservice.product_service.utils;

import com.netguides.base_domains.base_domains.records.CreateStockRequest;
import com.productservice.product_service.records.CreateProductRequest;
import com.productservice.product_service.entity.ProductEntity;

public class ProductUtils {

    public static ProductEntity convertToEntity(CreateProductRequest product) {

        return ProductEntity.builder().
                brand(product.brand()).
                productName(product.productName()).
                price(product.price()).
                category(product.category()).
                description(product.description()).
                status(product.status())
                .build();

    }

    public static CreateProductRequest convertToDto(ProductEntity entity) {
        return CreateProductRequest.builder().
                productid(entity.getProductId()).
                productName(entity.getProductName()).
                description(entity.getDescription()).
                category(entity.getCategory()).
                brand(entity.getBrand()).
                price(entity.getPrice()).
                status(entity.getStatus())
                .build();

    }

    public static CreateStockRequest createStockRequestObj(ProductEntity entity, CreateProductRequest request) {
        return CreateStockRequest.builder().
                productId(entity.getProductId()).
                productName(entity.getProductName()).
                availableQuantity(request.quantity()).
                build();
    }
}
