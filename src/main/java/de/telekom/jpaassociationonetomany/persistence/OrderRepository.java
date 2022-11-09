package de.telekom.jpaassociationonetomany.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.telekom.jpaassociationonetomany.model.Order;
import de.telekom.jpaassociationonetomany.model.OrderItem;

@Repository
public class OrderRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public Order findOrderByID(Long id) {
		return em.find(Order.class, id);
	}

	@Transactional
	public void saveOrder(Order order) {
		
		em.persist(order);
	}
	
	
}
