package com.example.orderProcessingSystem.demo.order;

import java.io.Serializable;

public enum OrderStatus implements Serializable {
    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELED
}
