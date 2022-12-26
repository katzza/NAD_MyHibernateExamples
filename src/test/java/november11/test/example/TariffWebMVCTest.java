package november11.test.example;

import november11.test.example.model.Todo;
import november11.test.example.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebMvcTest()
@ActiveProfiles("test1")
public class TariffWebMVCTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private TodoService todoService;

	@Test
	void testFindAll() throws Exception {
		when(todoService.getTodos()).thenReturn(Arrays.asList(new Todo("1. Todo"), new Todo("2. Todo")));

		mvc.perform(MockMvcRequestBuilders.get("/todos")) // => http-Methoden
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("1. Todo"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].description").value("2. Todo"));
	}

	@Test
	void testAddTodo() throws Exception {
		Todo todo = new Todo("Test");

		mvc.perform(MockMvcRequestBuilders.post("/todos").contentType(MediaType.APPLICATION_JSON)
				.content("{\"description\":\"Test\"}")).andExpect(MockMvcResultMatchers.status().is(201));

		verify(todoService,times(1)).addTodo(any(Todo.class));
	}
}
