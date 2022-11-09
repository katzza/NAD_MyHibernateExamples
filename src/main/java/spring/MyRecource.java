package spring;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.dto.TodoDto;
import spring.model.Todo;
import spring.service.TodoService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.jboss.logging.Logger.getLogger;

@RestController
@RequestMapping(path = "/todos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class MyRecource {

    @Autowired
    TodoService todoService;

    private static final Logger LOGGER = getLogger(MyRecource.class);

    @GetMapping("/greeting")
    @ResponseBody
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        LOGGER.info("Greeting");
        return "greeting " + name;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        LOGGER.info("GET all");
        return todoService.getAllTodos();
    }

    @GetMapping("{id}")
    public Optional<Todo> getById(@PathVariable("id") Long id) {
        LOGGER.info("GET single");
        return todoService.getById(id);
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    @Transactional(rollbackOn = Exception.class)
    public Todo newTodo(@RequestBody Todo newTodo) throws Exception {
        if (newTodo == null) throw new Exception("NOT_PRESENT");
        LOGGER.info("POST");
        return todoService.saveTodo(newTodo);
    }


}
