package com.example.orderProcessingSystem.demo.controller;

import com.example.orderProcessingSystem.demo.dto.OrderDto;
import com.example.orderProcessingSystem.demo.dto.OrderItemDto;
import com.example.orderProcessingSystem.demo.exception.ApplicationException;
import com.example.orderProcessingSystem.demo.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NamingException;

@RestController
@Validated
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@Valid @RequestBody OrderDto orderDto)throws ApplicationException, NamingException {
        Integer Id = orderService.addOrder(orderDto);
        String successMessage = "INSERT_SUCCESS " + Id;
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

}
