package com.system.service.impl;

import com.system.model.entity.Product;
import com.system.model.enums.Category;
import com.system.repository.ProductRepository;
import com.system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Set<Category> getAllCategories() {

        return Optional.ofNullable(productRepository.getAllCategories())
                .orElseThrow(() -> new IllegalArgumentException("Products not found."));
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {

        return Optional.ofNullable(productRepository.getProductsByCategory(category))
                .orElseThrow(() -> new IllegalArgumentException("Products not found."));
    }

    @Override
    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public void updateProductById(Integer id, Product product) {

        productRepository.updateProductById(id, product.getName(), product.getPrice(), product.getDescription(), product.isAvailability(), product.getQuantity(), product.getCategory());
    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Integer deleteProductById(Integer id) {
        return productRepository.deleteProductById(id);
    }
}
