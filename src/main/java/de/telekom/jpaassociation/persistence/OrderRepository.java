package de.telekom.jpaassociation.persistence;

import de.telekom.jpaassociation.model.Order;
import de.telekom.jpaassociation.model.OrderItem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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


	public List<Order> findAll() {
		return em.createQuery("from Order").getResultList();
	}
}
