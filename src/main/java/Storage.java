import java.io.*;
import java.util.ArrayList;

public class Storage {
    private static ArrayList<Task> nlist = new ArrayList<Task>();
    public Storage(String filename)  {
        loadFile(filename,this.nlist);

    }
    public ArrayList<Task> Getlist(){
        return nlist;
    }

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
}
