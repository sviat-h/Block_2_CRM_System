package com.system.service.impl;

import com.system.model.entities.Account;
import com.system.model.entities.Order;
import com.system.model.entities.Product;
import com.system.repository.AccountRepository;
import com.system.repository.OrderRepository;
import com.system.security.filters.JwtRequestFilter;
import com.system.service.OrderService;
import com.system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final AccountRepository accountRepository;

    @Override
    public List<Order> getAllOrders() {

        return Optional.of(orderRepository.findAll())
                .orElseThrow(() -> new IllegalArgumentException("Orders not found."));
    }

    @Override
    public Order buy(List<Product> orderedProducts) {
        Integer quantity = 0;
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        List<Product> availableProducts = new ArrayList<>();
        List<Account> accounts = List.of(accountRepository.findAccountByUsername(JwtRequestFilter.currentUsername));

        for (Product orderedProduct : orderedProducts) {
            Product productInStock = productService.findProductById(orderedProduct.getId());
            if (Objects.nonNull(productInStock) && productInStock.getQuantity() >= orderedProduct.getQuantity()) {
                availableProducts.add(productInStock);
                productInStock.setQuantity(productInStock.getQuantity() - orderedProduct.getQuantity());

                productService.updateProductById(orderedProduct.getId(), productInStock);

                quantity += orderedProduct.getQuantity();
                totalPrice = totalPrice.add(productInStock.getPrice().multiply(BigDecimal.valueOf(orderedProduct.getQuantity())));
            } else {
                throw new NoSuchElementException("Products with id: " + orderedProduct.getId() + " not found, or their number is insufficient");
            }
        }
        return Optional.of(orderRepository.save(new Order(LocalDate.now(), totalPrice, quantity, availableProducts, accounts)))
                .orElseThrow(() -> new IllegalArgumentException("Orders not found."));
    }

    @Override
    public List<Order> findOrdersByAccountId(Integer id) {
        return Optional.of(orderRepository.findOrdersByAccountId(id))
                .orElseThrow(() -> new IllegalArgumentException("Orders not found."));
    }
}
