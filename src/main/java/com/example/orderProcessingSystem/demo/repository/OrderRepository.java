package com.example.orderProcessingSystem.demo.repository;

import com.example.orderProcessingSystem.demo.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDetail, Integer> {
}
