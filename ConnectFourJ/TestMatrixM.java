/**
 *
 * If we try to write to a file that doesn’t exist, the file will be created first and no exception will be thrown (except using Path method).
 * Always close the output stream after writing the file content to release all resources. It will also help in not corrupting the file.
 * Use PrintWriter is used to write formatted text.
 * Use FileOutputStream to write binary data.
 * Use DataOutputStream to write primitive data types.
 * Use FileChannel to write larger files.
 */

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.*;

import java.util.Scanner;
import java.util.*;

 class Matrix {
     private static int[] add;


     //Read to the Matrix

     // I am creating a Temp matrix

     @NotNull
     public static int[][] MatrixM() throws Exception {
         int[][] myArray;
         FileReader fr = new FileReader("/home/florin/IdeaProjects/Viking/src/matrix0.txt");
         Scanner sc = new Scanner(new BufferedReader(fr));


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

//             System.out.println(Arrays.deepToString(myArray));
         return myArray;
     }



     public void Write2DMatrix(int[][] matrixes) throws Exception {
         BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/florin/IdeaProjects/Viking/src/matrix0.txt")));

         StringBuilder sb = new StringBuilder();

         for (int r = 0; r < 6; r++) {
             for (int c = 0; c < 7; c++) {
                 sb.append(matrixes[r][c]).append("   ");
             }
             sb.append("\n");
         }

         bw.write(sb.toString());
         bw.close();
     }


     public static List<int[]> Vectors2D() {
         List<int[]> path = new ArrayList<>();

         path.add(new int[]{0, 0});
         path.add(new int[]{0, 1});
         path.add(new int[]{0, 2});
         path.add(new int[]{0, 3});
         //Generally path.add(new int[]{row, column}) of the element chosen in the path

         return path;
     }


     // New Updates for o whole vector

     public static int[][] UpdateMatrixVec(int[][] Matrix, List<int[]> vec) {

         for (int row = 0; row < 6; row++) {
             for (int col = 0; col < 7; col++)
                 for (int[] ints : vec)
                     if (row == ints[0] && col == ints[1]) Matrix[row][col] = Matrix[row][col] + 1;
                     else Matrix[row][col] = Matrix[row][col];
         }

         return Matrix;
     }

     @NotNull
     @Contract(pure = true)
     public static int[] Viky1(int[][] Matrix, int rov, int clov) {
         int[] ar = new int[3];
         ar[0] = Matrix[rov][clov];
         ar[1] = rov;
         ar[2] = clov;
         return ar;
     }

     @NotNull
     @Contract(pure = true)
     public static int[] MaxOlista1(List<int[]> vec) {
         int max = 0;
         int row;
         int col;
         int[] array = new int[3];

         for (int[] ints : vec) {

             if (max <= ints[0]) {
                 max = ints[0];
                 array[0] = max;
                 row = ints[1];
                 array[1] = row;
                 col = ints[2];
                 array[2] = col;

             }

         }
         return array;
     }

     public static int[][] Matrix0() throws Exception {
         int[][] myArray;
         FileReader fr = new FileReader("/home/florin/IdeaProjects/Viking/src/matrix0.txt");
         Scanner sc = new Scanner(new BufferedReader(fr));

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

//             System.out.println(Arrays.deepToString(myArray));
         return myArray;
     }

     public static int[][] Matrix1() throws Exception {
         int[][] myArray;
         FileReader fr = new FileReader("/home/florin/IdeaProjects/Viking/src/matrix1.txt");
         Scanner sc = new Scanner(new BufferedReader(fr));


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

//             System.out.println(Arrays.deepToString(myArray));
         return myArray;
     }

     public static int[] BackTracking(int[][] matrix, List<int[]> vec) {
         int[] punish = new int[3];
         int count = vec.size() - 1;
         for (int i = count; count >= 0; count--) {
             int rowp = vec.get(count)[0];
             int colp = vec.get(count)[1];
             if (matrix[rowp][colp] != 0) {
                 int valp = matrix[rowp][colp];
                 punish[0] = rowp;
                 punish[1] = colp;
                 punish[2] = valp;
                 break;
             }

         }
         return punish;
     }
     public static HashMap< int[], List<int []>> HMP(){

     HashMap< int[] , List<int []>> hashMap = new HashMap<>();
     for( int col = 0; col< 7; col++){
         for( int row = 0; row< 6; row++){
             try {
                 hashMap.put(new int[]{row,col}, Collections.singletonList(new int[]{0, 0}));

             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
     }
     return hashMap;}

     public static void MatrixVector(){
         Vector< List<int []>> matvec = new Vector<>();
         for(int col = 0; col< 7; col++){
             for(int row = 0; row < 6; row ++){

             }
         }
     }
 }



//

public class TestMatrixM {
    public static void main(String[] args) throws NullPointerException, IOException {
        FileWriter fileWriter = new FileWriter("/home/florin/IdeaProjects/Viking/src/WinLoss1.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
    List< List<int []>> vecol = new ArrayList<>();
     List<int []> vrow = new ArrayList<>() ;
     for(int row = 0; row < 7; row++){
     vrow.add(new int[]{row, 1});
         System.out.println(vrow.get(row)[0]);
         vecol.add(vrow);
     }

     for( int colon = 0; colon< 6; colon++){
         for( int rol = 0; rol< 7; rol++){
             System.out.printf("%10d,%2d",vecol.get(colon).get(rol)[0],colon*vecol.get(colon).get(rol)[1]);
             printWriter.printf("%10d,%2d",vecol.get(colon).get(rol)[0],colon*vecol.get(colon).get(rol)[1]);


 }
         System.out.println("\n");
         printWriter.println("\n");
     }
     printWriter.close();


    }}

