import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Duke {

    public static TaskList tasks;
    public static Ui ui;
    public static Storage storage;

    public Duke(String filepath) {

        storage = new Storage(filepath);
        ui = new Ui();

        while (true) {

            tasks = new TaskList(storage.Getlist());

            try {
                File fold = new File(filepath);
                fold.delete();
                FileWriter fw = new FileWriter(filepath);
                Storage.writeToFile(fw, storage.Getlist());
                fw.close();

            } catch (IOException e) {
                System.out.println("Something Went Wrong!");
            }
        }
    }
    public void run(){

    }


    public static void main(String[] args) {
        new Duke("duke.txt").run();
    }
}