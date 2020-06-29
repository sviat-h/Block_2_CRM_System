package com.system.repository;

import com.system.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "select orders.id, date, total_price, quantity from orders inner join orders_accounts on orders.id = order_id where  accounts_id =:id", nativeQuery = true)
    List<Order> findOrdersByAccountId(@Param("id") Integer id);
}
