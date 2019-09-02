public class Event extends Task{
    protected String at;


    public Event(String description, String at) throws DukeException {
        super(description);
        this.at = at;
        Type = TypeClass.E;

    }
    public String GetAt(){
        return at;
    }




    @Override
    public String toString() {
        return "[E][" + getStatusIcon()+ "]" + description + " (at: " + at + ")";
    }
}