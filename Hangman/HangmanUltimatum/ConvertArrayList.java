
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ConvertArrayList {

    ArrayList<String> stringArrayList = new ArrayList<>();
    private static final String COMMA_DELIMITER = ",";
    int count = 0;
    int limit;

    public  void creatArray()

    {
//        String[] ReadcsvArray = new String[10000];



        Scanner scanner = null;
        try {
            //Get the scanner instance
            scanner = new Scanner(new File("C:\\Users\\postelnicu\\IdeaProjects\\FlorinJavaProject\\src\\JavaFlorin01\\src\\listofwordsj.csv"));
            //Use Delimiter as COMMA
            scanner.useDelimiter(COMMA_DELIMITER);
            while(scanner.hasNext())
            {


//                System.out.print(scanner.next()+"   ");
                stringArrayList.add(scanner.next().strip());
//                ReadcsvArray[count] = scanner.next().strip();
//                System.out.println(ReadcsvArray[count]);

//                System.out.println(stringArrayList.get(count) + " of index : " + count);
//                count++;

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


//class TestConvertArrayList {
//    public static void main(String[] args) {
//        ConvertArrayList cov = new ConvertArrayList();
//
//        System.out.println(cov.stringArrayList.size() + "     " + cov.count);
//
//    }

