import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.reflect.*;

/* deals with updating of tasklist
    Commands: todo..., deadline..,event..., delete .., done..,
 */
public class TaskList {

    public TaskList( ArrayList<Task> list) {

        Scanner scanner;
        String inputString;


        scanner = new Scanner(System.in);
        inputString = scanner.nextLine();

        String[] wordsplit = inputString.split(" ");
        if (inputString.equalsIgnoreCase("bye")) {
            System.out.print("Bye. Hope to see you again soon!");
            //break;

        } else if (wordsplit[0].equalsIgnoreCase("done")) {
            Parser.done(wordsplit,list);
            /*int index = Integer.parseInt(wordsplit[1]) - 1;
            list.get(index).markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.print(" [" + list.get(index).getStatusIcon() + "] ");
            System.out.println(list.get(index).description);*/

        } else if (wordsplit[0].equalsIgnoreCase("list")) {
            Parser.list(wordsplit,list);
            /*int j = 1;
            for (int i = 0; i < list.size(); i++) {

                System.out.print(j);
                System.out.print(".[");
                System.out.print(list.get(j - 1).getStatusIcon());
                System.out.print("] ");
                System.out.println(list.get(j - 1).description);

                j++;
            }*/
        } else if (wordsplit[0].equalsIgnoreCase("delete")) {
            Parser.delete(wordsplit,list);
            /*int rm = Integer.parseInt(wordsplit[1]) - 1;
            String status = list.get(rm).getStatusIcon();
            Task.TypeClass type1 = list.get(rm).getType();
            String des = list.get(rm).toString();
            list.remove(rm);
            System.out.println("Noted. I've removed this task:");
            System.out.println(des);
            System.out.println("Now you have " + list.size() + " tasks in the lists.");*/
        } else if (wordsplit[0].equalsIgnoreCase("find")) {
            Parser.find(wordsplit,list);
           /* ArrayList<Task> matchlist = new ArrayList<Task>();
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
            }*/
        } else if (wordsplit[0].equalsIgnoreCase("todo")) {
            Parser.todo(wordsplit,list);
            /*try {
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
            }*/

        } else if (wordsplit[0].equalsIgnoreCase("event")) {
            Parser.event(wordsplit,list);
            /*try {
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
            }*/
        } else if (wordsplit[0].equalsIgnoreCase("deadline")) {
            Parser.deadline(wordsplit,list);
            /*try {
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
            }*/
        } else {
            System.out.println("Please enter a valid command");
        }



    }





}
