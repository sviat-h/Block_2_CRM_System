package com.system.model.entity;

import com.system.model.enums.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    Order order;
}
