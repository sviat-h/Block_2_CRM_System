package com.system.service.impl;

import com.system.model.entities.Account;
import com.system.model.entities.Order;
import com.system.model.entities.Product;
import com.system.repository.AccountRepository;
import com.system.repository.OrderRepository;
import com.system.repository.ProductRepository;
import com.system.security.filters.JwtRequestFilter;
import com.system.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final AccountRepository accountRepository;

    @Override
    public List<Order> getAllOrders() {

        return Optional.of(orderRepository.findAll())
                .orElseThrow(() -> new IllegalArgumentException("Orders not found."));
    }

    @Override
    public Order buy(List<Product> products) {
        Integer quantity = 0;
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        List<Product> availableProducts = new ArrayList<>();
        List<Account> accounts = List.of(accountRepository.findAccountByUsername(JwtRequestFilter.currentUsername));

        for (Product product : products) {
            Product availableProduct = productRepository.findProductById(product.getId());
            if (Objects.nonNull(availableProduct) && availableProduct.getQuantity() >= product.getQuantity()) {
                availableProducts.add(availableProduct);
                availableProduct.setQuantity(availableProduct.getQuantity() - product.getQuantity());

                if (availableProduct.getQuantity().equals(0)) {

                    availableProduct.setAvailability(false);
                }
                productRepository.updateProductById(product.getId(), availableProduct.getName(), availableProduct.getPrice(), availableProduct.getDescription(), availableProduct.isAvailability(), availableProduct.getQuantity(), availableProduct.getCategory());

                quantity += product.getQuantity();
                totalPrice = totalPrice.add(availableProduct.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())));
            } else {
                throw new NoSuchElementException("Products with id: " + product.getId() + " not found, or their number is insufficient");
            }
        }
        return Optional.of(orderRepository.save(new Order(LocalDate.now(), totalPrice, quantity, availableProducts, accounts)))
                .orElseThrow(() -> new IllegalArgumentException("Orders not found."));
    }
}
