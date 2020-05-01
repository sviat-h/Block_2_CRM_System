package com.system.repository;

import com.system.model.entity.Product;
import com.system.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select category from Product")
    Set<Category> getAllCategories();

    List<Product> getProductsByCategory(Category category);

    Product findProductById(Integer id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Product pr set pr.name=:name, pr.price=:price, pr.description=:description, pr.availability=:availability, pr.quantity=:quantity, pr.category =:category where pr.id =:prId")
    void updateProductById(@Param("prId") Integer id, @Param("name") String name, @Param("price") BigDecimal price, @Param("description") String description, @Param("availability") boolean availability, @Param("quantity") Integer quantity, @Param("category") Category category);

    @Modifying(clearAutomatically = true)
    @Transactional
    Integer deleteProductById(Integer id);
}
