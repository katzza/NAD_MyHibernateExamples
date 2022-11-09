package de.telekom.jpaassociation;

import de.telekom.jpaassociation.model.Order;
import de.telekom.jpaassociation.model.OrderItem;

import de.telekom.jpaassociation.persistence.OrderItemRepository;
import de.telekom.jpaassociation.persistence.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class InitData implements CommandLineRunner{

    @Autowired
    OrderRepository orderRepo;
    @Autowired
    OrderItemRepository orderItemRepo;


    @Override
    public void run(String... args) throws Exception {

        Order order1 = new Order("1. Testorder");
        orderRepo.saveOrder(order1);

        OrderItem orderItem11 = new OrderItem("1. Testposition für 1", order1);
        orderItemRepo.saveOrderItem(orderItem11);
        OrderItem orderItem12 = new OrderItem("2. Testposition für 1", order1);
        orderItemRepo.saveOrderItem(orderItem12);

        Order order2 = new Order("2. Testorder");
        orderRepo.saveOrder(order2);

        OrderItem orderItem21 = new OrderItem("1. Testposition für 2", order2);
        orderItemRepo.saveOrderItem(orderItem21);
        OrderItem orderItem22 = new OrderItem("2. Testposition für 2", order2);
        orderItemRepo.saveOrderItem(orderItem22);
        OrderItem orderItem23 = new OrderItem("3. Testposition für 2", order2);
        orderItemRepo.saveOrderItem(orderItem23);


        System.out.println("Order Items");
        for (OrderItem orderItem: orderItemRepo.findAll()) {

            System.out.println(orderItem);
        }

        System.out.println("Order");

        for (Order order: orderRepo.findAll()) {
            for (OrderItem orderItem : order.getItems())
                System.out.println(orderItem);
        }
    }

}
