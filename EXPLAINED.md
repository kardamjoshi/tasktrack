********* Day 1: Records ********

1)Why records instead of regular classes for User/Project/Task.?
-> records does not need set up constructers or getter setter it will be done automatically by the compiler itself.
records are not mutable you can not change with setter because there is none.  i will use classes when i need mutable objects when it can be changed by anyone. 

2)Why title and project are validated but assignee isn't ?
-> assignee it should be optional my real world solution is we have to flag it to show the assigner of the task that this task is unassigned so it could assign in future in dashboard or somewhere. because there might a new project in progress where all the task is getting created but the team is not fix or people are still getting selected for the project. 

3)The equals/hashCode gap you identified in question 2 earlier, and that it's a known todo for Phase 2, not forgotten.
-> eventually add a method like task.assignee(), callers checking for "is this unassigned" should ideally use Optional<User> rather than raw null-checks everywhere.

## Day 2: TaskStatus as a sealed interface

**Q: Why a sealed interface instead of an enum for TaskStatus?**
An enum is a fixed set of constants, but each constant is a single shared
object, so it can't hold different data per use. My `Blocked` status needs a
reason that differs for each task. With a sealed interface, `Blocked` is a
record I can create many times, each with its own reason, and its constructor
rejects a blank reason. `Todo`, `InProgress` and `Done` carry no data, so they
are empty records. The set of statuses is still closed, like an enum.

**Q: What does `permits` do?**
It controls which types may *implement* the interface, not who can use it as a
type. The permitted types must be in the same package (or module) if they're in
separate files, and each must be final, sealed or non-sealed. Records are
implicitly final. I tested this by adding an unlisted class that implements
TaskStatus, and the compiler refused it.

**Q: What does "the compiler knows all the subtypes" give me?**
Nobody can quietly add a fifth status. It also lets a switch over TaskStatus
be checked for completeness without a `default` branch (Day 3).

**Q: Tell me about a bug you hit.**
I changed `long id` to `Long id` because `id == null` gave a compile error on
a primitive. That silenced the error but the design was wrong. A primitive can
never be null, so the error meant the check was pointless. I reverted to `long`
and used a single `id <= 0` check, which also catches an unset id (defaults
to 0).

**Q: Why is `title` validated but `assignee` not?**
An unassigned task is a valid state (project staffing may not be decided yet),
so null is a deliberate decision there, not an oversight. `project` and
`status` are always required.

**Known todo:** records generate equals() from all fields, which is wrong for
things with an id. Revisit in Phase 2 when these become JPA entities.

