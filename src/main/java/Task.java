
    public class Task {
        protected String description;
        protected boolean isDone;

        public Task(String description) throws DukeException {
            if(description.equals(null)){
                throw new DukeException("Cannot be empty" );
            }else if (description.equals("todo")){
                throw new DukeException("fail" );
            }
            else {
                this.description = description;
                this.isDone = false;
            }
        }

        public String getStatusIcon() {
            return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
        }

        public boolean markAsDone(){

            return isDone = true;
        }
    }



