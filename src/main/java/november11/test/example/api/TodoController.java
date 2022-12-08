package november11.test.example.api;

import november11.test.example.model.Todo;
import november11.test.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/todos", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
public class TodoController {

	private TodoService service;

	@Autowired
	public TodoController(TodoService service) {
		this.service = service;

	}

	@GetMapping
	// localhost:8080/todos/ GET
	public List<Todo> getTodos() {

		return service.getTodos();
	}
	
	@PostMapping
	// localhost:8080/todos/ POST
	public ResponseEntity<Todo>  addTodo(@RequestBody Todo todo) {
		return new ResponseEntity<Todo>(service.addTodo(todo), HttpStatus.CREATED);
		
		
	}

	@GetMapping("/{id}")
//  localhost:8080/todos/4711      GET
	public ResponseEntity<Todo> getTodo(@PathVariable("id") Long id) {
		Optional<Todo> todo = service.getTodo(id);
		if (todo.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(todo.get());
	}

}
