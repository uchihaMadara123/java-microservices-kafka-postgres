package com.netguides.stock_service.service;

import com.netguides.base_domains.base_domains.dto.Order;
import com.netguides.base_domains.base_domains.records.CreateStockRequest;
import com.netguides.base_domains.base_domains.records.CreateStockResponse;
import com.netguides.base_domains.base_domains.records.ProductStockResponse;
import com.netguides.stock_service.entity.StockEntity;
import com.netguides.stock_service.repository.StockRepository;
import com.netguides.stock_service.utils.StockUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository, OrderHistoryService orderHistoryService) {
        this.stockRepository = stockRepository;
    }

    public void updateStock(Order order) {
        Optional<StockEntity> entity =
                Optional.ofNullable(stockRepository.findByProductName(order.getProductName()));

        entity.ifPresent(obj -> {
            Long availableQuantity = obj.getAvailableQuantity();
            Long updatedQuantity = availableQuantity - order.getQuantity();
            obj.setAvailableQuantity(updatedQuantity);
            stockRepository.save(obj);
        });
    }

    public CreateStockResponse createInitialStock(CreateStockRequest request){
        StockEntity entity = StockUtils.convertToStockEntity(request);
        StockEntity savedEntity = this.stockRepository.save(entity);
       return StockUtils.convertToStockResponse(savedEntity);
    }

    public ProductStockResponse getProductStockQuantity(Long productId){
        StockEntity entity = this.stockRepository.findByProductId(productId);
        return StockUtils.convertToProductStockResponse(entity);
    }
}
