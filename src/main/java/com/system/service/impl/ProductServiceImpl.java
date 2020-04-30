package com.system.service.impl;

import com.system.model.entity.Product;
import com.system.model.enums.Category;
import com.system.repository.ProductRepository;
import com.system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Set<Category> getAllCategories() {
        return productRepository.getAllCategories();
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {

        return productRepository.getProductsByCategory(category);
    }
}
