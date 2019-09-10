/**
 * Subclass of task called to-do.
 */
public class Todo extends Task {
    /**
     * Creates a To-do object.
     * @param description Description of a task
     */
    public Todo(String description)  {
        super(description);
        Type = TypeClass.T;

    }
    /**
     * Converts the To-do object to a string.
     * @return This returns the string of the To-do object
     */
    @Override
    public String toString() {
        return  "[T][" + getStatusIcon()+ "] " + description;
    }
}

