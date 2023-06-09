package com.example.orderProcessingSystem.demo.repository;

import com.example.orderProcessingSystem.demo.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
