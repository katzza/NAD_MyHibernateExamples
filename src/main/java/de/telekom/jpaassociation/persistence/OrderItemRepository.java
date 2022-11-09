package de.telekom.jpaassociation.persistence;

import de.telekom.jpaassociation.model.OrderItem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


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

	public List<OrderItem> findAll() {
		return em.createQuery("from OrderItem").getResultList();
	}
}
