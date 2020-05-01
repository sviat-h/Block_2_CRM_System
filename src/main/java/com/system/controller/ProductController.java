package com.system.controller;

import com.system.model.entity.Product;
import com.system.model.enums.Category;
import com.system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/add")
    public Product addProduct(@RequestBody Product product) {

        return productService.addProduct(product);
    }

    @PutMapping(value = "/update/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {

        productService.updateProductById(id, product);
        return productService.findProductById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {

        if (productService.deleteProductById(id).equals(1)) {
            return "Successfully deleted.";
        }

        return "Product with such id not found.";
    }
}
