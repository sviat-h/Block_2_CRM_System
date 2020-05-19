package com.system.service;

import com.system.model.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    List<Order> getAllOrders();
}
