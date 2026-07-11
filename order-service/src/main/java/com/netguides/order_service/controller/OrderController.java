package com.netguides.order_service.controller;

import com.netguides.base_domains.base_domains.dto.Order;
import com.netguides.order_service.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class OrderController {

    private final OrderService orderService ;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public String placeOrder(@Valid  @RequestBody Order order){
        return orderService.placeOrder(order);
    }
}
