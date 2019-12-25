

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.util.Scanner;

public class Read2DArrayFromFile {
    public static void main(String[] args) throws Exception {
        int[][] myArray;
        try (FileReader fr = new FileReader("C://Users/flori/IdeaProjects/Viking/src/matrix.txt")) {
            try (Scanner sc = new Scanner(new BufferedReader(fr))) {


                int rows = 6;
                int columns = 7;
                myArray = new int[rows][columns];
                while (sc.hasNextLine()) {
                    // Split in lines; number of lines = size of array
                    for (int i = 0; i < myArray.length; i++) {
                        String[] line = sc.nextLine().trim().split("   ");
                        // Split each line in entries, by reading each integer
                        // split by how many blanks are in between
                        for (int j = 0; j < line.length; j++) {
                            myArray[i][j] = Integer.parseInt(line[j]);
                        }
                    }
                }
            }
            System.out.println(Arrays.deepToString(myArray));
        }
        catch(Exception e){
            System.out.println(e.fillInStackTrace());
        }

    }
}