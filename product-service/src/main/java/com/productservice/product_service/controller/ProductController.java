package com.productservice.product_service.controller;

import com.netguides.base_domains.base_domains.records.ProductStockResponse;
import com.productservice.product_service.records.CreateProductRequest;
import com.productservice.product_service.service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1")
public class ProductController {

    private final ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public CreateProductRequest getProduct(@PathVariable Long productId) {
        return null;
    }

    @PostMapping("/product")
    public CreateProductRequest getProduct(@RequestBody CreateProductRequest product) {
        return productService.createProduct(product);
    }


    @GetMapping("/product/stock/{productId}")
    public ProductStockResponse getProductInventory(@PathVariable Long productId) {
        return productService.getProductStock(productId);
    }


}
