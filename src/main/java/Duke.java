import java.io.*;
import java.lang.reflect.Array;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Duke {
    private static ArrayList<Task> list = new ArrayList<Task>();





    public static void loadFile(String fileName, ArrayList<Task> list) {
        try {
            String w = null;
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((w = bufferedReader.readLine()) != null){
            //List<String> lines = Files.readAllLines(Paths.get(filePath));
            //for(String w:lines) {
                String[] splitline = w.split(" " + "\\|" + " ", 0);
                switch (splitline[0]) {
                    case("T"):
                        Todo temp = new Todo(splitline[2]);
                        if (splitline[1].equals("1")) temp.markAsDone();
                        list.add(temp);
                        break;
                    case("D"):
                        Deadline temp2 = new Deadline(splitline[2],splitline[3]);
                        if (splitline[1].equals("1")) temp2.markAsDone();
                        list.add(temp2);
                        break;
                    case("E"):
                        Event temp3 = new Event(splitline[2],splitline[3]);
                        if (splitline[1].equals("1")) temp3.markAsDone();
                        list.add(temp3);
                        break;
                    default:
                        break;
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }
    public static void writeToFile(FileWriter fw, ArrayList<Task> list) throws IOException {
        for(Task item:list){
            switch(item.getType()){
                case T:
                    fw.write("T | " + (item.status().equals(true) ? "1" : "0") + " | " + item.GetDes() +'\n');
                    break;
                case D:
                    fw.write("D | " + (item.status().equals(true) ? "1" : "0") + " | " + item.GetDes() + " | " + ((Deadline) item).GetBy() + "\n");
                    break;
                case E:
                    fw.write("E | " + (item.status().equals(true) ? "1" : "0") + " | " + item.GetDes() + " | " + ((Event) item).GetAt() + "\n");
                    break;
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
        System.out.print("Hello, I'm Duke. \n What can i do for you? \n");
        Scanner scanner;
        String inputString;
        loadFile("savefile.txt",list);

        while (true){

            scanner = new Scanner(System. in);
            inputString = scanner. nextLine();
            String[] wordsplit = inputString.split(" ");
            if(inputString.equalsIgnoreCase("bye")) {
                System.out.print("Bye. Hope to see you again soon!");
                break;

            }else if (wordsplit[0].equalsIgnoreCase("done")) {
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
            }else if (wordsplit[0].equalsIgnoreCase("delete")) {

                int rm = Integer.parseInt(wordsplit[1]) - 1;
                String status = list.get(rm).getStatusIcon();
                Task.TypeClass type1 = list.get(rm).getType();
                String des = list.get(rm).toString();
                list.remove(rm);
                System.out.println("Noted. I've removed this task:");
                System.out.println( des);
                System.out.println("Now you have " + list.size() + " tasks in the lists.");
            } else if(wordsplit[0].equalsIgnoreCase("find")) {
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
            }else if (wordsplit[0].equalsIgnoreCase("todo")) {
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
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("todo what?");
                }

            } else if (wordsplit[0].equalsIgnoreCase("event")) {
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
                }catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("What kind of event?");
                }


            } else if (wordsplit[0].equalsIgnoreCase("deadline")) {
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
               }catch(ArrayIndexOutOfBoundsException e){
                   System.out.println("What kind of deadline?");
               }
            } else {
                System.out.println("Please enter a valid command");
            }

            try {
                File fold = new File("savefile.txt");
                fold.delete();
                FileWriter fw = new FileWriter("savefile.txt");
                writeToFile(fw, list);
                fw.close();

            }
            catch (IOException e) {
                System.out.println("Something Went Wrong!");
            }

            }


    }

}
