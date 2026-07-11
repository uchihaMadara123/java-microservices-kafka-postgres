package com.netguides.order_service.service;

import com.netguides.base_domains.base_domains.dto.Order;
import com.netguides.base_domains.base_domains.dto.OrderEvent;
import com.netguides.order_service.entity.OrderEntity;
import com.netguides.order_service.kafkaproducers.OrderProducer;
import com.netguides.order_service.repository.OrderRepository;
import com.netguides.order_service.utils.OrderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderProducer orderProducer;
    private final OrderRepository orderRepository;

    public OrderService(OrderProducer orderProducer,OrderRepository orderRepository1) {
        this.orderProducer = orderProducer;
        this.orderRepository = orderRepository1;
    }

    @Transactional
    public String placeOrder(Order order){
        String orderId = UUID.randomUUID().toString();
        order.setOrderId(orderId);
        OrderEvent orderEvent = new OrderEvent
                ("Order status is in pending state","Pending",order);
        OrderEntity entity = OrderUtils.buildOrderEntity(order);
        orderRepository.save(entity);
        orderProducer.sendMessage(orderEvent);

        return "Order Placed Successfully : "+ orderId;
    }
}
