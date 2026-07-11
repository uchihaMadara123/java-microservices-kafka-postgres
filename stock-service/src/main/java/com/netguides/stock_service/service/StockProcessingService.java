package com.netguides.stock_service.service;

import com.netguides.base_domains.base_domains.dto.Order;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StockProcessingService {
    private final OrderHistoryService orderHistoryService;
    private final StockService stockService;

    public StockProcessingService(OrderHistoryService orderHistoryService, StockService stockService) {
        this.orderHistoryService = orderHistoryService;
        this.stockService = stockService;
    }
    @Transactional
    public void process(Order order){
        orderHistoryService.saveOrderHistory(order);
        stockService.updateStock(order);
    }
}
