package de.telekom.jpaassociationonetomany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue
	//@GeneratedValue(strategy = GenerationType.AUTO) Auto = Default
	private Long id;
	
	private String orderItemDescription;
	
	
	
	// Default Constructor notwendig für Hibernate
	//eventuell private machen, weil er von außen nicht aufgerufen werden soll
	public OrderItem() {}



	public OrderItem(String orderItemDescription) {
		super();
		this.orderItemDescription = orderItemDescription;
	}



	public String getOrderItemDescription() {
		return orderItemDescription;
	}



	public void setOrderItemDescription(String orderItemDescription) {
		this.orderItemDescription = orderItemDescription;
	}



	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderItemDescription=" + orderItemDescription + "]";
	}
	
	
	
	
	
	
	
}
