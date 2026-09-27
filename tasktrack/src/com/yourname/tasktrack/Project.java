package com.yourname.tasktrack;

public record Project(Long id, String name, String description) {
	
	public Project{
	
		if (id == null) {
			throw new IllegalArgumentException("Id must not be null");
		}
	
		if (id <= 0) {
			throw new IllegalArgumentException("Id must be positive");
		}
	
		if (name.isBlank()) {
			throw new IllegalArgumentException("Name must not be blank");
		}
		
		if (name.equals(null)) {
			throw new IllegalArgumentException("Name must not be null");
		}
		
		if (description.isBlank()) {
			throw new IllegalArgumentException("Description must not be blank");
		}
		
		if (description.equals(null)) {
			throw new IllegalArgumentException("Description must not be null");
		}
	}
}


