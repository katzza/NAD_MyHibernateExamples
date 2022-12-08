package november11.test.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
	@Id
	@GeneratedValue
	private Long id;

	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + "]";
	}

	public Todo(String description) {
		super();

		this.description = description;
	}

	public Todo(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Todo() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
