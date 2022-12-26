package de.telekom.jpaassociationbidirectional.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue
	//@GeneratedValue(strategy = GenerationType.AUTO) Auto = Default
	private Long id;
	
	private String orderItemDescription;
	@ManyToOne
	Order order;
	
	//Konstruktoren
	public OrderItem() {}

	public OrderItem(String orderItemDescription, Order order) {
		this.orderItemDescription = orderItemDescription;
		this.order = order;
	}

	//Getter und Setter
	public String getOrderItemDescription() {
		return orderItemDescription;
	}

	public void setOrderItemDescription(String orderItemDescription) {
		this.orderItemDescription = orderItemDescription;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	//ToString()
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderItemDescription=" + orderItemDescription + "]";
	}
	
	
	
}
