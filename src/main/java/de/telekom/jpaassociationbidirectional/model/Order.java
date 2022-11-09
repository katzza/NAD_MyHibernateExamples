package de.telekom.jpaassociationbidirectional.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_order")
@NamedQuery(name = ConstantsModel.ORDERFIND, query = "select distinct o from Order o left join fetch o.listOrderItem where o.orderDescription = ?1")
public class Order {
	
	@Id
	@GeneratedValue
	private Long orderId;
	private String orderDescription;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> listOrderItem;
	
	
	
	//Konstruktoren
	
	public Order() {}

	public Order(String orderDescription, List<OrderItem> listOrderItem) {
		super();
		this.orderDescription = orderDescription;
		this.listOrderItem = listOrderItem;
	}

	/*
	 * //Hilfsfunktion public void addItem(OrderItem item) {
	 * this.listOrderItem.add(item); item.setOrder(this); }
	 */
	
	//Getter und Setter
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public List<OrderItem> getListOrderItem() {
		return listOrderItem;
	}

	public void setListOrderItem(List<OrderItem> listOrderItem) {
		this.listOrderItem = listOrderItem;
	}

		
	//toString
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDescription=" + orderDescription + ", listOrderItem="
				+ listOrderItem + "]";
	}
	
	
}
