package com.netguides.stock_service.service;

import com.netguides.base_domains.base_domains.dto.Order;
import com.netguides.stock_service.entity.OrderHistoryEntity;
import com.netguides.stock_service.repository.OrderHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryService {

    private final OrderHistoryRepository orderHistoryRepository;

    public OrderHistoryService(OrderHistoryRepository orderHistoryRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }

    public void saveOrderHistory(Order order){

        OrderHistoryEntity entity = new OrderHistoryEntity();
        entity.setOrderId(order.getOrderId());
        entity.setQuantity(order.getQuantity());
        entity.setStatus(order.getStatus());
        entity.setCustomerName(order.getCustomerName());
        entity.setProductName(order.getProductName());

        orderHistoryRepository.save(entity);

    }
}
