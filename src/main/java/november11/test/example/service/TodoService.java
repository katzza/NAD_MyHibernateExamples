package november11.test.example.service;


import november11.test.example.model.Todo;
import november11.test.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TodoService {

	private TodoRepository repository;

	@Autowired
	public TodoService(TodoRepository repository) {
		this.repository = repository;
	}

	public List<Todo> getTodos() {
		return repository.findAll();

	}
	
	public Optional<Todo> getTodo(Long id) {
		return repository.findById(id);

	}

	public Todo addTodo(Todo todo) {
		return repository.save(todo);
	}

}
