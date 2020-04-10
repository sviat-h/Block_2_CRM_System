package com.system.model.entity;

import lombok.Data;

import javax.management.relation.Role;
import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "confirm_password")
    private String confirmPassword;

    @Column(columnDefinition = "varchar", name = "role")
    private Role role;

    @OneToOne(mappedBy = "account")
    private User user;
}
