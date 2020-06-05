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
        validateProduct(product);

        return productRepository.save(product);
    }

    @Override
    public void updateProductById(Integer id, Product product) {
        validateProduct(product);

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

    private void validateProduct(Product product) {
        isAvailable(product);
        validatePrice(product);
        validateQuantity(product);
    }

    private void isAvailable(Product product) {
        if (product.getQuantity() > 0) {
            product.setAvailability(true);
        } else {
            product.setAvailability(false);
        }
    }

    private void validatePrice(Product product) {
        if (product.getPrice().doubleValue() <= 0) {
            throw new ExceptionInInitializerError("The price cannot be less or equal to 0");
        }
    }

    private void validateQuantity(Product product) {
        if (product.getQuantity() < 0) {
            throw new ExceptionInInitializerError("Quantity of products cannot be less than 0");
        }
    }
}
