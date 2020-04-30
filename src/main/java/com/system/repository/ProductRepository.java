package com.system.repository;

import com.system.model.entity.Product;
import com.system.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select category from Product")
    Set<Category> getAllCategories();

    List<Product> getProductsByCategory(Category category);
}
