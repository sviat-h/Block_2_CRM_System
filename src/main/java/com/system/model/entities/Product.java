package com.system.model.entities;

import com.system.model.enums.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "availability")
    private boolean availability;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(columnDefinition = "varchar", name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "orders_accounts",
            joinColumns = @JoinColumn(name = "accounts_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;
}
