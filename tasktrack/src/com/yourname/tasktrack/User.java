package com.yourname.tasktrack;

public record User(Long id, String name, String email) {

	public User {

		if (id == null) {
			throw new IllegalArgumentException("id must not be null");
		}

		if (id <= 0) {
			throw new IllegalArgumentException("id must be positive");
		}

		if (name.isBlank()) {
			throw new IllegalArgumentException("name must not be blank");
		}
		
		if (name.equals(null)) {
			throw new IllegalArgumentException("name must not be null");
		}
		
		if (email.isBlank() || email == null || !email.contains("@")) {
			throw new IllegalArgumentException("email format invalid");
		}
		
	}
}
