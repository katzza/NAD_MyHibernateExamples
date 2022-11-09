package de.telekom.jpaassociationbidirectional.persistence;

public class OrderDTO {

	
	private String message;
	
	public OrderDTO(Long id, String description) {
		this.message = id + " " + description;
	}

	public String getMessage() {
		return message;
	}

	
	
}
