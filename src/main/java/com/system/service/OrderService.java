package com.system.service;

import com.system.model.entities.Order;
import com.system.model.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    List<Order> getAllOrders();

    Order buy(List<Product> product);
}
