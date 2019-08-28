import java.io.*;
import java.net.URI;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class Duke {
    static StringBuffer stringBufferOfData = new StringBuffer();
    static String filename = null;
    static Scanner sc = new Scanner(System.in);



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
    public static void level3() throws DukeException {


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
              try {
                  Task t = new Task(wordsplit[0] + " " + wordsplit[1]);
                  list.add(t);
              }
              catch (DukeException e){
                  System.out.println(e.getMessage());
              }
            }
        }
    }
    public static void level4() {
        ArrayList<Task> list = new ArrayList<Task>();

        while (true) {

                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                String[] splitt = input.split(" ");
                if (splitt[0].equalsIgnoreCase("list")) {
                    int j = 1;
                    for (int k = 0; k < list.size(); k++) {

                        System.out.print(j);
                        System.out.print(". ");
                        System.out.println(list.get(j - 1).toString());
                        j++;
                    }
                } else if (splitt[0].equalsIgnoreCase("done")) {
                    int index = Integer.parseInt(splitt[1]) - 1;
                    list.get(index).markAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(list.get(index).toString());
                } else if (splitt[0].equalsIgnoreCase("bye")) {
                    System.out.print("Bye. Hope to see you again soon!");
                    break;
                } else {

                    String[] wordsplit = input.split(" ");
                    String cmd = wordsplit[0];
                    String det = wordsplit[1];
                    for (int i = 2; i < wordsplit.length; i++) {
                        det += " " + wordsplit[i];
                    }
                    if (cmd.equalsIgnoreCase("todo")) {
                       try {
                           Todo td = new Todo(det);
                           list.add(td);
                           System.out.println("Got it. I've added this task:");
                           System.out.println("[T][" + td.getStatusIcon() + "] " + det);
                           System.out.println("Now you have " + list.size() + " tasks in the lists.");
                       }
                       catch (DukeException e){
                           System.out.println(e);
                       }
                    } else if (cmd.equalsIgnoreCase("event")) {
                        try {
                            String[] secsplit = det.split("/");
                            secsplit[1] = secsplit[1].substring(3);
                            Event ev = new Event(secsplit[0], secsplit[1]);
                            list.add(ev);
                            System.out.println("Got it. I've added this task:");
                            System.out.println("[E][" + ev.getStatusIcon() + "] " + secsplit[0] + " (at:" + secsplit[1] + ")");
                            System.out.println("Now you have " + list.size() + " tasks in the lists.");
                        }
                        catch(DukeException e){
                            System.out.println(e);
                        }

                    } else if (cmd.equalsIgnoreCase("deadline")) {
                        try {
                            String[] secsplit = det.split("/");
                            secsplit[1] = secsplit[1].substring(3);
                            Deadline dl = new Deadline(secsplit[0], secsplit[1]);
                            list.add(dl);
                            System.out.println("Got it. I've added this task:");
                            System.out.println("[D][" + dl.getStatusIcon() + "] " + secsplit[0] + " (by:" + secsplit[1] + ")");
                            System.out.println("Now you have " + list.size() + " tasks in the lists.");
                        }
                        catch (DukeException e){
                            System.out.println(e);
                        }
                    }
                }

            }

        }
   /* public void save(String fileName) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
        for ( Task task : list)
            pw.println(task.getStatusIcon());
        pw.close();
    }*/
    private static boolean readFile() {
        System.out.println("Please enter your files name and path i.e C:\\test.txt: ");//prompt for file name
        filename = sc.nextLine();//read in the file name
        Scanner fileToRead = null;
        try {
            fileToRead = new Scanner(new File(filename)); //point the scanner method to a file
            //check if there is a next line and it is not null and then read it in
            for (String line; fileToRead.hasNextLine() && (line = fileToRead.nextLine()) != null; ) {
                System.out.println(line);//print each line as its read
                stringBufferOfData.append(line).append("\r\n");//this small line here is to appened all text read in from the file to a string buffer which will be used to edit the contents of the file
            }
            fileToRead.close();//this is used to release the scanner from file
            return true;
        } catch (FileNotFoundException ex) {//if the file cannot be found an exception will be thrown
            System.out.println("The file " + filename + " could not be found! " + ex.getMessage());
            return false;
        } finally {//if an error occurs now we close the file to exit gracefully
            fileToRead.close();
            return true;
        }
        }
    private static void writeToFile() {
        try {
            BufferedWriter bufwriter = new BufferedWriter(new FileWriter(filename));
            bufwriter.write(stringBufferOfData.toString());//writes the edited string buffer to the new file
            bufwriter.close();//closes the file
        } catch (Exception e) {//if an exception occurs
            System.out.println("Error occured while attempting to write to file: " + e.getMessage());
        }
    }
    private static void replacement() {
        System.out.println("Please enter the contents of a line you would like to edit: ");//prompt for a line in file to edit
        String lineToEdit = sc.nextLine();//read the line to edit
        System.out.println("Please enter the the replacement text: ");//prompt for a line in file to replace
        String replacementText = sc.nextLine();//read the line to replace

        int startIndex = stringBufferOfData.indexOf(lineToEdit);//now we get the starting point of the text we want to edit
        int endIndex = startIndex + lineToEdit.length();//now we add the staring index of the text with text length to get the end index
        stringBufferOfData.replace(startIndex, endIndex, replacementText);//this is where the actual replacement of the text happens
        System.out.println("Here is the new edited text:\n" + stringBufferOfData); //used to debug and check the string was replaced
    }

    public static void level7(){

        boolean fileRead = readFile();//call the method to read the file with the files name
        if (fileRead) {//if the read file was successfull
            replacement();//call method to get text to replace, replacement text and output replaced String buffer
            writeToFile();
        }
        System.exit(0);//exit once app is done

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
        level7();

    }

}
