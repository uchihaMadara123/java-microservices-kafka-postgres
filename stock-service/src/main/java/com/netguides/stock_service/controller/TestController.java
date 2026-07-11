package com.netguides.stock_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test/stockservice")
    public String hello() {
        return "Stock Service Working Fine";
    }
}
