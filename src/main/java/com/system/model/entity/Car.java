package com.system.model.entity;

import com.system.model.enums.Brand;
import com.system.model.enums.TypeOfCar;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "availability")
    private boolean availability;

    @Column(columnDefinition = "varchar", name = "type")
    @Enumerated(EnumType.STRING)
    private TypeOfCar typeOfCar;

    @Column(columnDefinition = "varchar", name = "brand")
    @Enumerated(EnumType.STRING)
    private Brand brand;
}
