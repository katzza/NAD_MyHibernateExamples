package de.telekom.springdata;

import de.telekom.springdata.model.Order;
import de.telekom.springdata.model.OrderItem;
import de.telekom.springdata.persistence.OrderItemRepoInterface;
import de.telekom.springdata.persistence.OrderRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InitDataSpringData implements CommandLineRunner {

    @Autowired
    OrderRepoInterface orderRepo;
    @Autowired
    OrderItemRepoInterface orderItemRepo;
    static String s = "";

    @Override
    public void run(String... args) throws Exception {

        List<OrderItem> listeWolle = new ArrayList();
        List<OrderItem> listeHolz = new ArrayList();

        Order order1 = new Order("Holz", listeWolle);
        Order order2 = new Order("Holz", listeHolz);
        System.out.println(String.format("Hello, %s", order2));

        OrderItem orderItem1 = new OrderItem("Baumwolle", order1);
        OrderItem orderItem2 = new OrderItem("Merino rot", order1);
        OrderItem orderItem3 = new OrderItem("Purple Heart", order2);
        OrderItem orderItem4 = new OrderItem("Ebenholz", order2);
        OrderItem orderItem5 = new OrderItem("Douglasie", order2);


        listeWolle.add(orderItem1);
        listeWolle.add(orderItem2);
        listeHolz.add(orderItem3);
        listeHolz.add(orderItem4);
        listeHolz.add(orderItem5);


        orderRepo.save(order1);
        orderRepo.save(order2);

        orderItemRepo.save(orderItem1);
        orderItemRepo.save(orderItem2);
        orderItemRepo.save(orderItem3);
        orderItemRepo.save(orderItem4);
        orderItemRepo.save(orderItem5);


        System.out.println("----FIND ALL------");
        System.out.println("orderRepo.findAll");
        orderRepo.findAll().forEach(System.out::println);
        System.out.println("----------END---------------------");

        /*
         * System.out.println("orderRepo.findOrderByDescription"); for(Order o :
         * orderRepo.findOrderByDescription("Wolle")){ System.out.println(o); }
         */
        /*
         * System.out.println("-------------------------------");
         *
         * System.out.println("orderRepo.findOrderItemByDescriptionPreparedJoinFetch");
         * for(Order o : orderRepo.findOrderItemByDescriptionNamedQuery("Holz")){
         * System.out.println(o.getOrderDescription()); for(OrderItem oi :
         * o.getListOrderItem()) { System.out.println("\t" +
         * oi.getOrderItemDescription()); }
         * System.out.println("***************************"); }
         */


        System.out.println("-------------------------------");

        System.out.println("orderRepo.findOrderItemByDescriptionQueryString");
        for (Order o : orderRepo.findByDescription("Holz")) {
            System.out.println(o);
            System.out.println("***************************");
        }


        System.out.println("-------------------------------");

      /*  System.out.println("orderRepo.findOrderItemByDescriptionQueryObject");
        for (Object[] o : orderRepo.findOrderItemByDescriptionQueryObject()) {
            System.out.println(o[0] + " " + o[1]);
            System.out.println("***************************");
        }

        System.out.println("-------------------------------");

        System.out.println("orderRepo.findOrderItemByDescriptionQueryOrderDTO");
        for (OrderDTO o : orderRepo.findOrderItemByDescriptionQueryOrderDTO()) {
            System.out.println(o.getMessage());
            System.out.println("***************************");
        }*/
        var name = "yy";


        if (!name.isEmpty()) {
            create(name);
        }

        List<String> name2 = name.chars()
                .map(i -> i + 1)
                .mapToObj(x -> Character.toString((char) x)).toList();

        System.out.println(name2);

    }

    public static void create(String name) {
        s = "chchchchch"; //static - не роллбэк
        name = "NEW";    //локальная - роллбэк
        System.out.println(String.format("Hello, %s", name));
    }

}

	

