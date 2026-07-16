package com.productservice.product_service.feign;

import com.netguides.base_domains.base_domains.records.CreateStockRequest;
import com.netguides.base_domains.base_domains.records.ProductStockResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name ="stock-service")
public interface StockServiceFeign {

    @PostMapping("/api/v1/createInitalStock")
    public void createInitialStock(@RequestBody CreateStockRequest request);

    @GetMapping("/api/v1/product/stock/{productId}")
    public ProductStockResponse getProductStockQuantity(@PathVariable Long productId);
}
