public class Todo extends Task {


    public Todo(String description) throws DukeException {
        super(description);
        Type = TypeClass.T;

    }


    @Override
    public String toString() {
        return  "[T][" + getStatusIcon()+ "]" + description;
    }
}

