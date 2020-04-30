package com.system.service;

import com.system.model.entity.Product;
import com.system.model.enums.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ProductService {

    Set<Category> getAllCategories();

    List<Product> getProductsByCategory(Category category);
}
