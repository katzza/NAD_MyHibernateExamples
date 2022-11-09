package de.telekom.jpaassociation.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Comparable<Order>{

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    private List<OrderItem> items = new ArrayList<OrderItem>();

    public Order() {}

    public Order(String orderDescription) {
        super();
        this.description = orderDescription;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", description=" + description + "]";
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItems(OrderItem item) {
        this.items.add(item);
    }

    @Override
    public int compareTo(Order o) {
        return (int) (this.getId() - o.getId());
    }

}

