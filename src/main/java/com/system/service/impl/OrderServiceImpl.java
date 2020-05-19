package com.system.service.impl;

import com.system.model.entity.Order;
import com.system.repository.OrderRepository;
import com.system.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {

        return Optional.of(orderRepository.findAll())
                .orElseThrow(() -> new IllegalArgumentException("Orders not found."));
    }
}
