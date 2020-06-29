package com.system.controller;

import com.system.model.entities.Order;
import com.system.model.entities.Product;
import com.system.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/buy")
    public Order buy(@RequestBody List<Product> products) {
        return orderService.buy(products);
    }

    @GetMapping(value = "/find/{id}")
    public List<Order> findOrdersByAccountId(@PathVariable Integer id) {
        return orderService.findOrdersByAccountId(id);
    }
}
