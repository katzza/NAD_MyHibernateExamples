package spring.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.todo.model.Todo;
import spring.todo.service.TodoService;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    TodoService service;

    @Override
    public void run(String... args) throws Exception {

        for (long i = 1; i <= 5; i++) {
            Todo todo = new Todo("description " + i);
            service.saveTodo(todo);
        }
        System.out.println(service.getAllTodos().stream());
    }

}


