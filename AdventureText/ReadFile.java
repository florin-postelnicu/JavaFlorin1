
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    List<String> rooms = new ArrayList<>();
    ArrayList eachLine = new ArrayList();

    ReadFile(){
    // The name of the file to open
    String filename = "C:\\Users\\postelnicu\\MoreAppsJava01\\src\\Simplehashtable";


    // This will reference one line at a time
    String line = null;
    try {
        // fileReader reads text file in the default encoding.
        FileReader fileReader = new FileReader(filename);


        // Always wrap FileReader in  BufferReader
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null ){
            eachLine.add(line);

            System.out.println(line);
        }
        // Always close the file
        bufferedReader.close();
    }
    catch (FileNotFoundException ex){
        System.out.println("Unable to open the file " + filename + "  ");


    }
    catch(IOException ex){
        ex.printStackTrace();
    }
}
}
class TestReaderFile{
    public static void main(String[] args) {
        ReadFile rf = new ReadFile();

        System.out.println(rf.eachLine);
    }
}