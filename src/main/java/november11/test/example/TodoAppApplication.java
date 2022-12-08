package november11.test.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TodoAppApplication  {


	 
	 

	public static void main(String[] args) {
		ApplicationContext container = SpringApplication.run(TodoAppApplication.class, args);

	}

	

}
