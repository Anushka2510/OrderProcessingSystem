package com.example.orderProcessingSystem.demo.order;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "orderitem")
@NoArgsConstructor
public class OrderItem implements Serializable {

    @Id
    @Column(name="productid")
    private Integer productId;


    @Column(name="productname")
    private String productName;

    @Column(name = "unitprice")
    private float unitPrice;


    @ManyToOne
    @JoinColumn(name = "orderid",referencedColumnName = "orderid")
    private OrderDetail orderDetail;

    private int quantity;


    @Column(name="subtotal")
    private float subTotal;


    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }





}
