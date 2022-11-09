package de.telekom.jpaassociationbidirectional.persistence;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.telekom.jpaassociationbidirectional.model.ConstantsModel;
import de.telekom.jpaassociationbidirectional.model.Order;

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
	
	public void printOrder(Order order) {
		System.out.println(order.toString());
	}
	
	public List<Order> findAll() {
		String s = "select o from Order o";
		Query query = em.createQuery(s);
		return query.getResultList();
		
		
	}
	
	//Wegen Security Thematik ausgeblendet.
	//SQL Injection möglich
	/*
	 * public List<Order> findOrderByDescription (String description) {
	 * 
	 * String s = "select o from Order o where o.orderDescription = '" + description
	 * +"'"; Query query = em.createQuery(s); return query.getResultList();
	 * 
	 * }
	 */
	
	public List<Order> findOrderByDescriptionPrepared(String desc) {
		
		String s = "select o from Order o where o.orderDescription = :description";
		Query query = em.createQuery(s);
		query.setParameter("description", desc);
		return query.getResultList();
		
	}
	
	public List<Order> findOrderItemByDescriptionPreparedJoinFetch(String desc) {
		
		String s = "select distinct o from Order o left join fetch o.listOrderItem where o.orderDescription = :description ";
		Query query = em.createQuery(s);
		query.setParameter("description", desc);
		return query.getResultList();
		
	}
	
	public List<Order> findOrderItemByDescriptionNamedQuery(String desc) {
		
		
		Query query = em.createNamedQuery(ConstantsModel.ORDERFIND);
		query.setParameter(1, desc);
		return query.getResultList();
		
	}
	
	public List<Order> findOrderItemByDescriptionNativeQuery() {
		
		String nativeQuery = "select * from tbl_order";
		Query query = em.createNativeQuery(nativeQuery, Order.class);
		
		return query.getResultList();
		
	}
	
	public List<String> findOrderItemByDescriptionQueryString() {
		
		String jpaQuery = "select o.orderDescription from Order o";
		Query query = em.createQuery(jpaQuery);
		
		return query.getResultList();
		
	}
	
	public List<Object[]> findOrderItemByDescriptionQueryObject() {
		
		String jpaQuery = "select o.orderId, o.orderDescription from Order o";
		Query query = em.createQuery(jpaQuery);
		
		return query.getResultList();
		
	}
	
	public List<OrderDTO> findOrderItemByDescriptionQueryOrderDTO() {
		
		String jpaQuery = "select new de.telekom.jpaassociationbidirectional.persistence.OrderDTO (o.orderId, o.orderDescription) from Order o";
		Query query = em.createQuery(jpaQuery);
		
		return query.getResultList();
		
	}
	
	
	
	

}
