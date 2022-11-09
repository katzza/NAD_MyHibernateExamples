package de.telekom.springdata.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tbl_order")
@NamedQuery(name = ConstantsModel.ORDERFIND, query = "select distinct o from Order o left join fetch o.listOrderItem where o.orderDescription = ?1")
@NamedQuery(name = "Order.findByDescription", query = "select distinct o from Order o where o.orderDescription = ?1")
public class Order {
	
	@Id
	@GeneratedValue
	private Long orderId;
	private String orderDescription;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
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
	/*@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDescription=" + orderDescription + ", listOrderItem="
				+ listOrderItem + "]";
	}*/

	@Override
	public String toString() {
		return "Order{" +
				"orderId=" + orderId +
				", orderDescription='" + orderDescription + '\'' +
				", listOrderItem=" + listOrderItem +
				'}';
	}
}
