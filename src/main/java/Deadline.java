public class Deadline extends Task {

    protected String by;




    public Deadline(String description, String by) throws DukeException {
        super(description);
        this.by = by;
        Type = TypeClass.D;

    }
    public String GetBy(){
        return by;
    }

    @Override
    public String toString() {
        return "[D][" + getStatusIcon()+ "] " + description + " (by: " + by + ")";
    }
}