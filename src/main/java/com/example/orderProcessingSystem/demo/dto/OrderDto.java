package com.example.orderProcessingSystem.demo.dto;

import com.example.orderProcessingSystem.demo.order.OrderItem;
import com.example.orderProcessingSystem.demo.order.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Builder
public class OrderDto {

    @Id
    private Integer orderId;
    private String customerName;
    private String email;
    private String shippingAddress;
    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
    private float totalAmount;
    private Date orderDate;
    private OrderStatus status;

    public OrderDto(int orderId, String customerName, String email, String shippingAddress, List<OrderItem> orderItems, float totalAmount, Date orderDate, OrderStatus status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.status = status;
    }


}
