package com.example.orderProcessingSystem.demo.backend;
import com.example.orderProcessingSystem.demo.order.OrderDetail;
import jakarta.jms.*;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ShippingService {
    public static void main(String[] args) throws NamingException {
        InitialContext context = new InitialContext();
        Topic topic = (Topic) context.lookup("Topic/orderTopic");
        try(ActiveMQConnectionFactory cf=new ActiveMQConnectionFactory();
            JMSContext jmsContext= cf.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
            jmsContext.setClientID("shippingServiceApp");
            JMSConsumer consumer = jmsContext.createDurableConsumer(topic,"subscription3");
            Message message = consumer.receive();
            OrderDetail orderdetail = message.getBody(OrderDetail.class);
            System.out.println(orderdetail.getCustomerName());
            System.out.println(orderdetail.getEmail());

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
