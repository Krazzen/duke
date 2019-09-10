/**
 * Subclass of task called event.
 */
public class Event extends Task{
    protected String at;

    /**
     * Creates an Event object.
     * @param description Description of a event
     * @param at Date of event
     */
    public Event(String description, String at)  {
        super(description);
        this.at = at;
        Type = TypeClass.E;

    }
    /**
     * @return This returns time of Event object
     */
    public String GetAt(){
        return at;
    }

    /**
     * Converts the Event object to a string.
     * @return This returns the string of the Event object
     */
    @Override
    public String toString() {
        return "[E][" + getStatusIcon()+ "] " + description + " (at: " + at + ")";
    }
}