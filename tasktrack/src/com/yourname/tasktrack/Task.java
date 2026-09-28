package com.yourname.tasktrack;

public record Task(Long id, String title, String description , Project project, User assignee, TaskStatus status) {
	
	public Task {
        if (id == null) {
        	throw new IllegalArgumentException("id must not be null");
        }
        if (id <= 0) {
        	throw new IllegalArgumentException("id must be positive");
        }

        if (title == null || title.isBlank()) {
        	 throw new IllegalArgumentException("title must not be blank");
        }
           
        title = title.strip();
        if (project == null) {
        	throw new IllegalArgumentException("project must not be null");
        }
        if (status == null) {
        	 throw new IllegalArgumentException("status must not be null");
        }
           
    }
}



