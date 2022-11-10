package spring.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.todo.repository.TodoRepositoryIf;
import spring.todo.dto.TodoDto;
import spring.todo.model.Todo;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepositoryIf todoRepositoryIf;

    public List<Todo> getAllTodos() {
        return todoRepositoryIf.findAll();
    }

    public List<Todo> getByDescription(String description) {
        return todoRepositoryIf.findByDescription(description);
    }

    public Optional<Todo> getById(Long id) {
        return todoRepositoryIf.findById(id);
    }

    public Todo addTodo(TodoDto todoDto) {
        Todo newTodo = new Todo(todoDto.description);
        return todoRepositoryIf.save(newTodo);
    }

    public Todo saveTodo(Todo todo) {
        return todoRepositoryIf.save(todo);
    }
}
