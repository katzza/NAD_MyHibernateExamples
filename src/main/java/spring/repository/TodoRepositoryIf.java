package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Todo;

import java.util.List;

@Repository
public interface TodoRepositoryIf extends JpaRepository <Todo, Long> {
    List<Todo> findByDescription(String description);
}
