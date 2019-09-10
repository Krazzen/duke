import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.reflect.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

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
            System.exit(0);

            //break;

        } else if (wordsplit[0].equalsIgnoreCase("done")) {
            Parser.done(wordsplit,list);

        } else if (wordsplit[0].equalsIgnoreCase("list")) {
            Parser.list(wordsplit,list);

        } else if (wordsplit[0].equalsIgnoreCase("delete")) {
            Parser.delete(wordsplit,list);

        } else if (wordsplit[0].equalsIgnoreCase("find")) {
            Parser.find(wordsplit,list);

        } else if (wordsplit[0].equalsIgnoreCase("todo")) {
            Parser.todo(wordsplit,list);


        } else if (wordsplit[0].equalsIgnoreCase("event")) {
            Parser.event(wordsplit,list);

        } else if (wordsplit[0].equalsIgnoreCase("deadline")) {
            Parser.deadline(wordsplit,list);

        } else {
            System.out.println("Please enter a valid command");
        }



    }





}
