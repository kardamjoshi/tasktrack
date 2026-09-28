package com.yourname.tasktrack;

public record Blocked(String reason) implements TaskStatus 
{
	public Blocked {
        if (reason == null || reason.isBlank())
            throw new IllegalArgumentException("reason must not be blank");
    }
}
