package de.telekom.jpaassociation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem implements Comparable<OrderItem>{

    @Id
    @GeneratedValue
    private Long id;

    private String orderItemDescription;
    @ManyToOne
    private Order order;

    public OrderItem() {}

    public OrderItem(String orderItemDescription, Order order) {
        super();
        this.orderItemDescription = orderItemDescription;
        this.order = order;
        order.addItems(this);
    }

    public Long getId() {
        return id;
    }

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

    public void addOrderItem(String orderItemDescription, Order order) {
        OrderItem item = new OrderItem(orderItemDescription, order);
    }

    @Override
    public String toString() {
        return "OrderItem [id=" + id + ", orderItemDescription=" + orderItemDescription + ", order=" + order + "]";
    }

    @Override
    public int compareTo(OrderItem oi) {
        return (int) (this.getId() - oi.getId());
    }

}

