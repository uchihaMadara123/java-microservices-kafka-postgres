package com.netguides.order_service.utils;

import com.netguides.base_domains.base_domains.dto.Order;
import com.netguides.order_service.entity.OrderEntity;

public class OrderUtils {
    public static OrderEntity buildOrderEntity(Order order){

        OrderEntity entity = new OrderEntity();
        entity.setOrderId( order.getOrderId());
        entity.setStatus(order.getStatus());
        entity.setPrice(order.getPrice());
        entity.setCustomerName(order.getCustomerName());
        entity.setProductName(order.getProductName());
        entity.setQuantity(order.getQuantity());
        return entity ;
    }
}
