package com.netguides.stock_service.service;

import com.netguides.base_domains.base_domains.dto.Order;
import com.netguides.stock_service.entity.StockEntity;
import com.netguides.stock_service.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository, OrderHistoryService orderHistoryService) {
        this.stockRepository = stockRepository;
    }

    public void updateStock(Order order){
        Optional<StockEntity> entity =
                Optional.ofNullable(stockRepository.findByProductName(order.getProductName()));

        entity.ifPresent(obj->{
            Integer availableQuantity = obj.getAvailableQuantity();
            Integer updatedQuantity = availableQuantity - order.getQuantity();
            obj.setAvailableQuantity(updatedQuantity);
            stockRepository.save(obj);
        });

}

}
