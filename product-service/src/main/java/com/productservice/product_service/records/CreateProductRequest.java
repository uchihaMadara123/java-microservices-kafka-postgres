package com.productservice.product_service.records;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CreateProductRequest(
        Long productid,
        String productName,
        String description,
        String category,
        String brand,
        BigDecimal price,
        String status,
        Long quantity
) {
}
