package com.system.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product> products;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Account> accounts;

    public Order(LocalDate date, BigDecimal totalPrice, Integer quantity, List<Product> products, List<Account> accounts) {
        this.date = date;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.products = products;
        this.accounts = accounts;
    }
}
