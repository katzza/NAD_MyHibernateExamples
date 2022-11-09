package de.telekom.jpaassociationbidirectional.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.telekom.jpaassociationbidirectional.model.OrderItem;

@Repository
public class OrderItemRepository {
	@PersistenceContext
	private EntityManager em;
	
	public OrderItem findOrderItemByID(Long id) {
		
		return em.find(OrderItem.class, id);
	}
	
	/*
	 * public void update() { Order o = em.find(Order.class, 1L);
	 * 
	 * OrderItem i = new OrderItem(); i.setOrder(o);
	 * 
	 * o.getListOrderItem().add(i);
	 * 
	 * em.persist(i); }
	 */
	
	@Transactional
	public void saveOrderItem(OrderItem oi) {
		
		em.persist(oi);
		printAll(oi);
	}
	public void printAll(OrderItem oi) {
		System.out.println(oi.toString());
	}
}




