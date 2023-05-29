package com.example.orderProcessingSystem.demo.dto;

import com.example.orderProcessingSystem.demo.order.OrderDetail;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderItemDto {

    @Id
    private Integer productId;
    private String productName;


    private float unitPrice;
    private int quantity;
    private float subTotal;
    @ManyToOne
    @JoinColumn(name = "orderid")
    private OrderDetail orderDetail;

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

//    public OrderItemDto(int productId, String productName, float unitPrice, int orderId,int quantity, float subTotal, OrderDetail orderDetail) {
//        this.productId = productId;
//        this.productName = productName;
//        this.unitPrice = unitPrice;
//        this.quantity = quantity;
//        this.subTotal = subTotal;
//        this.orderId=orderId;
//        this.orderDetail=orderDetail;
//    }


}
