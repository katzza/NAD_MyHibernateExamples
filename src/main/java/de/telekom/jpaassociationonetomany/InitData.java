package de.telekom.jpaassociationonetomany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.telekom.jpaassociationonetomany.model.Order;
import de.telekom.jpaassociationonetomany.model.OrderItem;
import de.telekom.jpaassociationonetomany.persistence.OrderItemRepository;
import de.telekom.jpaassociationonetomany.persistence.OrderRepository;


@Component
public class InitData implements CommandLineRunner {

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		List<OrderItem> listOrderItem = new ArrayList();
		
		OrderItem oi1 = new OrderItem("Order Item 1");
		OrderItem oi2 = new OrderItem("Order Item 2");
		orderItemRepo.saveOrderItem(oi1);
		orderItemRepo.saveOrderItem(oi2);
		
		listOrderItem.add(oi1);
		listOrderItem.add(oi2);
		
		Order order1 = new Order("erste Testorder", listOrderItem);
		orderRepo.saveOrder(order1);
		
	}

}
