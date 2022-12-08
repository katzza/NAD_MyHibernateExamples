package november11.test.example;

import november11.test.example.model.Todo;
import november11.test.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test1")
public class InitData implements CommandLineRunner {


	  @Autowired private TodoService service;
	 

	

	@Override
	public void run(String... args) throws Exception {
		
		
		  service.addTodo(new Todo("Todo1")); service.addTodo(new Todo("Todo2"));
		  
		  for (Todo todo : service.getTodos()) {
		  
		  System.out.println(todo); }
		 
	}
}
