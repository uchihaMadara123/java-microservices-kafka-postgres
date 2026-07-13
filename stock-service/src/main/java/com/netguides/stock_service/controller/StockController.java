package com.netguides.stock_service.controller;


import com.netguides.base_domains.base_domains.records.CreateStockRequest;
import com.netguides.base_domains.base_domains.records.CreateStockResponse;
import com.netguides.base_domains.base_domains.records.ProductStockResponse;
import com.netguides.stock_service.service.StockService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService ){
        this.stockService = stockService;
    }

    @PostMapping("/createInitalStock")
    public CreateStockResponse createInitialStock(@RequestBody CreateStockRequest request){
       return this.stockService.createInitialStock(request);
    }

    @GetMapping("/product/stock/{productId}")
    public ProductStockResponse getProductStockQuantity(@PathVariable Long productId){
        return this.stockService.getProductStockQuantity(productId);
    }
}
