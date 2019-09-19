
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ConvertArrayList {

    ArrayList<String> stringArrayList = new ArrayList<>();
    private static final String COMMA_DELIMITER = ",";

    public  void creatArray()

    {

        Scanner scanner = null;
        try {
            //Get the scanner instance
            scanner = new Scanner(new File("C:\\Users\\postelnicu\\IdeaProjects\\FlorinJavaProject\\src\\JavaFlorin01\\src\\listofwordsj.csv"));
            //Use Delimiter as COMMA
            scanner.useDelimiter(COMMA_DELIMITER);
            while(scanner.hasNext())
            {

                stringArrayList.add(scanner.next().strip());
            }
        }
        catch (FileNotFoundException fe)
        {
            fe.printStackTrace();
        }
        finally

        {
            scanner.close();
        }
    }
}
