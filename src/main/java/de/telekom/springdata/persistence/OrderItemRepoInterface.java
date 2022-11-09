package de.telekom.springdata.persistence;

import de.telekom.springdata.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepoInterface extends CrudRepository<OrderItem, Long> {
}
