package com.system.controller;

import com.system.model.entity.Product;
import com.system.model.enums.Category;
import com.system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/all")
    public Set<Category> getAllCategories() {

        return productService.getAllCategories();
    }

    @GetMapping(value = "/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable Category category) {

        return productService.getProductsByCategory(category);
    }
}
