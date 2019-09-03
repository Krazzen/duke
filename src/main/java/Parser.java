import java.util.ArrayList;

/* deals with making sense of the user command
    Commands: list, bye, find..
 */
public class Parser {


    public static void done(String[] wordsplit, ArrayList<Task> list) {
        int index = Integer.parseInt(wordsplit[1]) - 1;
        list.get(index).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.print(" [" + list.get(index).getStatusIcon() + "] ");
        System.out.println(list.get(index).description);
    }
    public static void list(String[] wordsplit, ArrayList<Task> list) {
        int j = 1;
        for (int i = 0; i < list.size(); i++) {

            System.out.print(j);
            System.out.print(".[");
            System.out.print(list.get(j - 1).getStatusIcon());
            System.out.print("] ");
            System.out.println(list.get(j - 1).description);

            j++;
        }
    }
    public static void delete(String[] wordsplit, ArrayList<Task> list){
        int rm = Integer.parseInt(wordsplit[1]) - 1;
        String status = list.get(rm).getStatusIcon();
        Task.TypeClass type1 = list.get(rm).getType();
        String des = list.get(rm).toString();
        list.remove(rm);
        System.out.println("Noted. I've removed this task:");
        System.out.println(des);
        System.out.println("Now you have " + list.size() + " tasks in the lists.");
    }
    public static void find(String[] wordsplit, ArrayList<Task> list) {
        ArrayList<Task> matchlist = new ArrayList<Task>();
        for (Task task : list) {
            String test = task.GetDes();
            boolean isFound = test.contains(wordsplit[1]);
            if (isFound) {
                matchlist.add(task);
            }
        }
        System.out.println("Here are the matching tasks in your list:");
        int j = 1;
        for (int i = 0; i < matchlist.size(); i++) {

            System.out.print(j);
            System.out.print(".[");
            System.out.print(matchlist.get(j - 1).getStatusIcon());
            System.out.print("] ");
            System.out.println(matchlist.get(j - 1).description);

            j++;
        }
    }
    public static void todo(String[] wordsplit, ArrayList<Task> list){
        try {
            String cmd = wordsplit[0];
            String det = wordsplit[1];
            for (int i = 2; i < wordsplit.length; i++) {
                det += " " + wordsplit[i];
            }

            Todo td = new Todo(det);
            list.add(td);
            System.out.println("Got it. I've added this task:");
            System.out.println("[T][" + td.getStatusIcon() + "] " + det);
            System.out.println("Now you have " + list.size() + " tasks in the lists.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("todo what?");
        }
    }
    public static void event(String[] wordsplit, ArrayList<Task> list){
        try {
            String cmd = wordsplit[0];
            String det = wordsplit[1];
            for (int i = 2; i < wordsplit.length; i++) {
                det += " " + wordsplit[i];
            }
            String[] secsplit = det.split("/");
            secsplit[1] = secsplit[1].substring(3);
            Event ev = new Event(secsplit[0], secsplit[1]);
            list.add(ev);
            System.out.println("Got it. I've added this task:");
            System.out.println("[E][" + ev.getStatusIcon() + "] " + secsplit[0] + " (at:" + secsplit[1] + ")");
            System.out.println("Now you have " + list.size() + " tasks in the lists.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("What kind of event?");
        }
    }
    public static void deadline(String[] wordsplit, ArrayList<Task> list){
        try {
            String cmd = wordsplit[0];
            String det = wordsplit[1];
            for (int i = 2; i < wordsplit.length; i++) {
                det += " " + wordsplit[i];
            }
            String[] secsplit = det.split("/");
            secsplit[1] = secsplit[1].substring(3);
            Deadline dl = new Deadline(secsplit[0], secsplit[1]);
            list.add(dl);
            System.out.println("Got it. I've added this task:");
            System.out.println("[D][" + dl.getStatusIcon() + "] " + secsplit[0] + " (by:" + secsplit[1] + ")");
            System.out.println("Now you have " + list.size() + " tasks in the lists.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("What kind of deadline?");
        }
    }

}
