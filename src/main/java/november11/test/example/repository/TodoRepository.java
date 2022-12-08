package november11.test.example.repository;

import november11.test.example.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  TodoRepository extends JpaRepository<Todo,Long> {

	

	/*
	 * public List<Todo> getTodos() {
	 * 
	 * return em.createQuery("select t from Todo as t").getResultList(); }
	 * 
	 * public Todo getTodo(Long id) {
	 * 
	 * return em.find(Todo.class,id); }
	 * 
	 * @Transactional public Todo addTodo(Todo todo) { em.persist(todo); return
	 * todo; }
	 */
}
