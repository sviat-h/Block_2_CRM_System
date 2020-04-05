package com.system.crm.block_2_crm_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Block2CrmSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(Block2CrmSystemApplication.class, args);
    }
}
