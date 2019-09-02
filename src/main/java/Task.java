
    public class Task {
        protected String description;
        public boolean isDone;
        public TypeClass Type;
        public enum TypeClass {
            T, D, E;
        }

        public Task(String description)  {

                this.description = description;
                this.isDone = false;

        }
        public TypeClass getType() {
            return this.Type;
        }

        public String getStatusIcon() {

            return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
        }
        public String status(){
            if (isDone) {
                return "true";
            }
            else{
                return "false";
            }
        }
        public String GetDes(){
            return description;
        }

        public boolean markAsDone(){

            return isDone = true;
        }
    }



