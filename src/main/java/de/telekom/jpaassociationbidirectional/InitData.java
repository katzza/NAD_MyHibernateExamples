package de.telekom.jpaassociationbidirectional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.telekom.jpaassociationbidirectional.model.Order;
import de.telekom.jpaassociationbidirectional.model.OrderItem;
import de.telekom.jpaassociationbidirectional.persistence.OrderDTO;
import de.telekom.jpaassociationbidirectional.persistence.OrderItemRepository;
import de.telekom.jpaassociationbidirectional.persistence.OrderRepository;

@Component
public class InitData implements CommandLineRunner{

	@Autowired 
	OrderRepository orderRepo;
	@Autowired
	OrderItemRepository orderItemRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		List<OrderItem> listeWolle = new ArrayList();
		List<OrderItem> listeHolz = new ArrayList();
		List<OrderItem> listeLebensmittel = new ArrayList();
		List<OrderItem> listeleer = new ArrayList();
		
		Order order1 = new Order("Holz", listeWolle);
		Order order2 = new Order("Holz", listeHolz);
		Order order3 = new Order("Lebensmittel", listeLebensmittel);
		Order order4 = new Order("Holz", listeleer);
		
		OrderItem orderItem1 = new OrderItem("Baumwolle", order1);
		OrderItem orderItem2 = new OrderItem("Merino rot", order1);
		OrderItem orderItem3 = new OrderItem("Purple Heart", order2);
		OrderItem orderItem4 = new OrderItem("Ebenholz", order2);
		OrderItem orderItem5 = new OrderItem("Douglasie", order2);
		OrderItem orderItem6 = new OrderItem("Salz", order3);
		OrderItem orderItem7 = new OrderItem("Butter", order3);
		OrderItem orderItem8 = new OrderItem("Spinat", order3);
		
		
		
		
		
		listeWolle.add(orderItem1);
		listeWolle.add(orderItem2);
		listeHolz.add(orderItem3);
		listeHolz.add(orderItem4);
		listeHolz.add(orderItem5);
		listeLebensmittel.add(orderItem6);
		listeLebensmittel.add(orderItem7);
		listeLebensmittel.add(orderItem8);
		
		orderRepo.saveOrder(order1);
		orderRepo.saveOrder(order2);
		orderRepo.saveOrder(order3);
		orderRepo.saveOrder(order4);
		orderItemRepo.saveOrderItem(orderItem1);
		orderItemRepo.saveOrderItem(orderItem2);
		orderItemRepo.saveOrderItem(orderItem3);
		orderItemRepo.saveOrderItem(orderItem4);
		orderItemRepo.saveOrderItem(orderItem5);
		orderItemRepo.saveOrderItem(orderItem6);
		orderItemRepo.saveOrderItem(orderItem7);
		orderItemRepo.saveOrderItem(orderItem8);
		
		/*
		 * System.out.println("-------------------------------");
		 * System.out.println("orderRepo.findAll"); for(Order o : orderRepo.findAll()) {
		 * System.out.println(o.getOrderDescription()); }
		 */
		
		System.out.println("-------------------------------");
		
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
		for(String s : orderRepo.findOrderItemByDescriptionQueryString()){
			System.out.println(s);
			System.out.println("***************************");
		}
		

		System.out.println("-------------------------------");
		
		System.out.println("orderRepo.findOrderItemByDescriptionQueryObject");
		for(Object[] o : orderRepo.findOrderItemByDescriptionQueryObject()){
			System.out.println(o[0] + " " + o[1]);
			System.out.println("***************************");
		}
		
		System.out.println("-------------------------------");
		
		System.out.println("orderRepo.findOrderItemByDescriptionQueryOrderDTO");
		for(OrderDTO o : orderRepo.findOrderItemByDescriptionQueryOrderDTO()){
			System.out.println(o.getMessage());
			System.out.println("***************************");
		}
		 
	}
		 
	}

	

