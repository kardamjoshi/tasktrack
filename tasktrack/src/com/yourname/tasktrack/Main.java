package com.yourname.tasktrack;

public class Main {

	public static void main(String[] args) {
		Project project = new Project(1L, "TaskTrack", "Test1");
        User alice = new User(101L, "Alice", "Test2@gmail.com");
        User bob   = new User(102L, "Bob", "Test3@gmail.com");

        Task t1 = new Task(1L, "Write tests", "Unit tests for TaskStatus",
                           project, alice, new Todo());
        Task t2 = new Task(2L, "Fix login bug", "Session expiry issue",
                           project, bob, new InProgress());
        Task t3 = new Task(3L, "Migrate DB", "Move to Postgres 16",
                           project, alice, new Blocked("waiting on approval"));

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
	
}
