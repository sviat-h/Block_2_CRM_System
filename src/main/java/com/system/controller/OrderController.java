package com.system.controller;

import com.system.model.entity.Order;
import com.system.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping(value = "/all")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }
}
