import java.io.*;
import java.util.ArrayList;
/**
 * Deals with loading or saving tasklist to and from a file.
 */
public class Storage {
    public static ArrayList<Task> list = new ArrayList<Task>();
    /**
     * Creates Storage object.
     * @param filename String of the file's filepath
     */
    public Storage(String filename)  {
        loadFile(filename,list);

    }
    /**
     * @return  updated tasklist
     */
   public static ArrayList<Task> Getlist(){
        return list;
    }
    /**
     * Loads the file and TaskList object with tasks in the file.
     * @param list To update the TaskList object with tasks from the file
     * @param fileName String of the file's filepath
     *
     */
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
    /**
     * Updates the file in the filepath with the current
     * list of tasks that the user has set.
     * @param list TaskList object with existing tasks to be saved in the file
     * @throws IOException failed or interrupted I/O operations.
     */
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
}