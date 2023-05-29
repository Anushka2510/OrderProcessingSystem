package com.example.orderProcessingSystem.demo.service;

import com.example.orderProcessingSystem.demo.dto.OrderDto;
import com.example.orderProcessingSystem.demo.dto.OrderItemDto;
import com.example.orderProcessingSystem.demo.order.OrderDetail;
import com.example.orderProcessingSystem.demo.order.OrderItem;
import com.example.orderProcessingSystem.demo.repository.OrderItemRepository;
import com.example.orderProcessingSystem.demo.repository.OrderRepository;
import jakarta.jms.JMSContext;
import jakarta.jms.Topic;
import jakarta.validation.Valid;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "orderService")
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    public Integer addOrder(@Valid OrderDto orderDto) throws NamingException {
        InitialContext context = new InitialContext();
        Topic topic = (Topic) context.lookup("Topic/orderTopic");
        try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
             JMSContext jmsContext = cf.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
             OrderDetail orderDetail = OrderDetail.builder()
                    .orderId(orderDto.getOrderId())
                    .customerName(orderDto.getCustomerName())
                    .email(orderDto.getEmail())
                    .shippingAddress(orderDto.getShippingAddress())
                    .totalAmount(orderDto.getTotalAmount())
                     .orderDate(orderDto.getOrderDate())
                     .status(orderDto.getStatus())
                    .build();

            List<OrderItem> orderItems = orderDto.getOrderItems();
            for (OrderItem orderItem : orderItems) {
                orderItem.setOrderDetail(orderDetail);
            }

            orderDetail.setOrderItems(orderItems);
            orderRepository.save(orderDetail);
            jmsContext.createProducer().send(topic, orderDetail);
            System.out.println("message sent");
            return orderDetail.getOrderId();

        }
    }
}
