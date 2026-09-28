package com.yourname.tasktrack;

public record Task(long id, String title, String description, Project project, User assignee, TaskStatus status) {
	
	public Task {
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



