import java.io.*;
import java.lang.reflect.Array;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Duke {

    public static TaskList tasks;
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.print("Hello, I'm Duke. \n What can i do for you? \n");
        Storage storage = new Storage("duke.txt");

        while (true){

            tasks = new TaskList(storage.Getlist());

            try {
                File fold = new File("duke.txt");
                fold.delete();
                FileWriter fw = new FileWriter("duke.txt");
                Storage.writeToFile(fw,storage.Getlist());
                fw.close();

            }
            catch (IOException e) {
                System.out.println("Something Went Wrong!");
            }


        }


    }

}
