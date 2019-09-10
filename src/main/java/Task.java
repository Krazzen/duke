/**
 * Represents main task of program
 */
    public class Task {
        protected String description;
        public boolean isDone;
        public TypeClass Type;
        public enum TypeClass {
            T, D, E;
        }
    /**
     * Creates Task object.
     * @param description The description of the task
     */
    public Task(String description)  {
        this.description = description;
        this.isDone = false;

        }
    /**
     * Returns type of task
     * @return  return object type
     */
    public TypeClass getType() {
            return this.Type;
        }
    /**
     * Checks whether the task is completed.
     * @return This returns a tick or cross depending on the boolean value of isDone
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    /**
     * Return status of task
     * @return True if task is done and false if not
     */
    public String status(){
        if (isDone) {
            return "true";
        }
        else{
            return "false";
        }
    }
    /**
     * Gets the description of a task.
     * @return  string description of the task
     */
    public String GetDes(){
        return description;
    }
    /**
     * Marks the task to done.
     */
    public boolean markAsDone(){
        return isDone = true;
    }
    }



