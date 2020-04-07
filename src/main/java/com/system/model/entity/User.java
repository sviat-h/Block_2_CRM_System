package com.system.model.entity;

import com.system.model.enums.Role;
import lombok.Data;

@Data
public class User {

    private Role role;

    private String password;
}
