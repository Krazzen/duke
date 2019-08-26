import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class Duke {
    public static void level1() {
        System.out.print("Hello, I'm Duke. \n What can i do for you? \n");
        Scanner scanner;
        String inputString;

        while (true){
            scanner = new Scanner(System. in);
            inputString = scanner. nextLine();
            if(inputString.equalsIgnoreCase("bye")) {
                break;
            }
            System.out.println(inputString);
        }
        System.out.print("Bye. Hope to see you again soon!");


    }
    public static void level2() {
        System.out.print("Hello, I'm Duke. \n What can i do for you? \n");
        Scanner scanner;
        String inputString = "";
        ArrayList<String> list=new ArrayList<String>();


        while (true){
            scanner = new Scanner(System. in);
            inputString = scanner. nextLine();
            if(inputString.equalsIgnoreCase("list")) {
                break;

            }
            list.add(inputString);
        }
        int j = 1;
        for(int i = 0; i < list.size();i++) {

            System.out.print(j);
            System.out.print(". ");
            System.out.println(list.get(j - 1));

            j++;
        }

    }
    public static void level3() {


        ArrayList<Task> list = new ArrayList<Task>();

        while (true) {

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] wordsplit = input.split(" ");

            if (wordsplit[0].equalsIgnoreCase("done")) {
                int index = Integer.parseInt(wordsplit[1]) - 1;
                list.get(index).markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.print(" [" + list.get(index).getStatusIcon() + "] ");
                System.out.println(list.get(index).description);

            } else if (wordsplit[0].equalsIgnoreCase("list")) {
                int j = 1;
                for (int i = 0; i < list.size(); i++) {

                    System.out.print(j);
                    System.out.print(".[");
                    System.out.print(list.get(j - 1).getStatusIcon());
                    System.out.print("] ");
                    System.out.println(list.get(j - 1).description);

                    j++;
                }
            } else if (wordsplit[0].equalsIgnoreCase("bye")) {
                System.out.print("Bye. Hope to see you again soon!");
                break;
            }
            else{
                Task t = new Task(wordsplit[0] + " " + wordsplit[1]);
                list.add(t);
            }
        }
    }
    public static void level4() {
        ArrayList<Task> list = new ArrayList<Task>();

        while (true) {

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] splitt = input.split(" ");
            if(splitt[0].equalsIgnoreCase("list")){
                    int j = 1;
                    for (int k = 0; k < list.size(); k++) {

                        System.out.print(j);
                        System.out.print(". ");
                        System.out.println(list.get(j - 1).toString());
                        j++;
                    }
                }
            else if (splitt[0].equalsIgnoreCase("done")) {
                int index = Integer.parseInt(splitt[1]) - 1;
                list.get(index).markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(list.get(index).toString());
            }
            else if (splitt[0].equalsIgnoreCase("bye")) {
                System.out.print("Bye. Hope to see you again soon!");
                break;
            }
            else{
                String[] wordsplit = input.split(" ");
                String cmd = wordsplit[0];
                String det = wordsplit[1];
                for (int i = 2; i < wordsplit.length; i++) {
                    det += " " + wordsplit[i];
                }
                if (cmd.equalsIgnoreCase("todo")) {
                    Todo td = new Todo(det);
                    list.add(td);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("[T][" + td.getStatusIcon() + "] " + det);
                    System.out.println("Now you have " + list.size() + " tasks in the lists.");
                }
                else if(cmd.equalsIgnoreCase("event")){
                    String[] secsplit = det.split("/");
                    secsplit[1] = secsplit[1].substring(3);
                    Event ev = new Event(secsplit[0],secsplit[1]);
                    list.add(ev);

                    System.out.println("Got it. I've added this task:");
                    System.out.println("[E][" + ev.getStatusIcon() + "] " + secsplit[0] + " (at:" + secsplit[1] + ")");
                    System.out.println("Now you have " + list.size() + " tasks in the lists.");
                }
                else if(cmd.equalsIgnoreCase("deadline")){
                    String[] secsplit = det.split("/");
                    secsplit[1] = secsplit[1].substring(3);
                    Deadline dl = new Deadline(secsplit[0],secsplit[1]);
                    list.add(dl);

                    System.out.println("Got it. I've added this task:");
                    System.out.println("[D][" + dl.getStatusIcon() + "] " + secsplit[0] + " (by:" + secsplit[1] + ")");
                    System.out.println("Now you have " + list.size() + " tasks in the lists.");
                }
            }


        }
    }



    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        //level1();
        //level2();
        //level3();
        level4();

    }

}
