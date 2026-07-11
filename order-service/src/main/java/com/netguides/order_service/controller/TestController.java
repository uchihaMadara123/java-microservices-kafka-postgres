package com.netguides.order_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test/orderservice")
    public String hello() {
        return "Order Service Working Fine";
    }
}
