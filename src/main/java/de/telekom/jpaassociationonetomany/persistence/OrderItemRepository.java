package de.telekom.jpaassociationonetomany.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.telekom.jpaassociationonetomany.model.OrderItem;



@Repository
public class OrderItemRepository {

	@PersistenceContext
	private EntityManager em;
	
	public OrderItem findOrderItemByID(Long id) {
		
		return em.find(OrderItem.class, id);
	}
	
	@Transactional
	public void saveOrderItem(OrderItem oi) {
		
		em.persist(oi);
	}
	
}
