1)Why records instead of regular classes for User/Project/Task.?
-> records does not need set up constructers or getter setter it will be done automatically by the compiler itself.
records are not mutable you can not change with setter because there is none.  i will use classes when i need mutable objects when it can be changed by anyone. 

2)Why title and project are validated but assignee isn't ?
-> assignee it should be optional my real world solution is we have to flag it to show the assigner of the task that this task is unassigned so it could assign in future in dashboard or somewhere. because there might a new project in progress where all the task is getting created but the team is not fix or people are still getting selected for the project. 

3)The equals/hashCode gap you identified in question 2 earlier, and that it's a known todo for Phase 2, not forgotten.
-> eventually add a method like task.assignee(), callers checking for "is this unassigned" should ideally use Optional<User> rather than raw null-checks everywhere.



