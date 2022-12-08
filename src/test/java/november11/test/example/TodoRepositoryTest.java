package november11.test.example;

import november11.test.example.model.Todo;
import november11.test.example.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test2")
class TodoRepositoryTest {
		
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private TodoRepository repository;

	@Test
	public void whenFindByName_thenReturnEmployee() {
		// given
		Todo todo = new Todo("t1");
		entityManager.persist(todo);
		entityManager.flush();

		// when
		Optional<Todo> found = repository.findById(1L);

		// then
		assertThat(found.get().getDescription()).isEqualTo(todo.getDescription());
	}
}