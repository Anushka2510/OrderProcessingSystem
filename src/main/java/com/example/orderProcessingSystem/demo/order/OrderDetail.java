package com.example.orderProcessingSystem.demo.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@Entity
@Table(name = "orderdetail")
@NoArgsConstructor
public class OrderDetail implements Serializable {

    @Id
    @Column(name = "orderid")
    private Integer orderId;

    @Column(name="customername")
    private String customerName;

    @Column(name="email")
    private String email;
    @Column(name="shippingaddress")
    private String shippingAddress;

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public OrderDetail(Integer orderId, String customerName, String email, String shippingAddress, List<OrderItem> orderItems, float totalAmount, Date orderDate, OrderStatus status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.status = status;
    }
    @Column(name="totalamount")
    private float totalAmount;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name="orderdate")
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;


}






