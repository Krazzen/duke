/**
 * Subclass of task called deadline.
 */

public class Deadline extends Task {

    protected String by;

    /**
     * Creates a Deadline object.
     * @param description Description deadline
     * @param by deadline of deadline(task)
     */
    public Deadline(String description, String by)  {
        super(description);
        this.by = by;
        Type = TypeClass.D;

    }
    /**
     * @return This returns the deadline of the Deadline object
     */
    public String GetBy(){
        return by;
    }

    /**
     * Converts the Deadline object to a string.
     * @return This returns the string of the Deadline object
     */
    @Override
    public String toString() {
        return "[D][" + getStatusIcon()+ "] " + description + " (by: " + by + ")";
    }
}