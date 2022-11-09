package de.telekom.springdata.persistence;

import de.telekom.springdata.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface OrderRepoInterface extends JpaRepository <Order, Long> {

    List<Order> findByDescription(String description);



}
