

import sun.rmi.runtime.NewThreadAction;

import java.io.PrintStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

 class Matrix {



    //Read to the Matrix

    // I am creating a Temp matrix

     public static  int[][] MatrixM() throws Exception{
         int[][] myArray;
         FileReader fr = new FileReader("/home/florin/IdeaProjects/Viking/src/matrix.txt");
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

     public void Write2DMatrix(int[][] matrixes) throws Exception{
         BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/home/florin/IdeaProjects/Viking/src/matrix.txt")));

         StringBuffer sb = new StringBuffer();

         for(int r =0;r< 6;r++){
             for(int c = 0; c< 7;c++){
                 sb.append(matrixes[r][c]+"   ");
             }
             sb.append("\n");
         }

         bw.write(sb.toString());
         bw.close();
     }






     public static int[][] UpdateMatrix(int[][] Matrix,int r, int c, int val){
         int updatedMatrix [][]= new int[6][7];

         for(int row = 0; row <6; row++){
             for(int col = 0; col <7; col++){
                 if(row ==r && col == c){
                     updatedMatrix[row][col]= val;

                 }
                 else{
                     updatedMatrix[row][col]= Matrix[row][col];
                 }
             }
         }
         return updatedMatrix;
     }

     public static List<int[]> Vectors2D (){
         List<int[]> path = new ArrayList<>();

             path.add(new int[]{0,0});
             path.add(new int[]{0,1});
             path.add(new int[]{0,2});
             path.add(new int[]{0,3});
             //Generally path.add(new int[]{row, column}) of the element chosen in the path

         return path;
     }


     // New Updates for o whole vector

         public static int[][]UpdateMatrixVec(int [][] Matrix, List<int[]> vec){

            for(int row = 0; row <6; row++){
                for(int col = 0; col <7; col++){
             for( int index = 0; index<  vec.size(); index ++){
                    if(row == vec.get(index)[0] && col == vec.get(index)[1]){
                        Matrix[row][col] = Matrix[row][col] +1 ;

                    }else{

                        Matrix[row][col] = Matrix[row][col] ;
                    }
                    }
                }
            }

        return Matrix;
     }
     public  static int[] Viky1(int[][] Matrix,int rov,int clov) {
         int[] ar = new int[3];
         ar[0] =  (int)Matrix[rov][clov];
         ar[1] = rov;
         ar[2] = clov;
         return ar;
     }
     public static int[] MaxOlista1(List<int[]> vec){
         int max = 0;
         int row =0;
         int col = 0;
         int array[] = new int[3];

         for(int i = 0; i < vec.size(); i++){

             if( max <= vec.get(i)[0]){
                 max = vec.get(i)[0];
                 array[0] = max;
                 row = vec.get(i)[1];
                 array[1] = row;
                 col = vec.get(i)[2];
                 array[2] =col;

             };

         }
         return array;
     }

     public static int SetEntry1(int[][]Matrix,int c, int r, int val){
         Matrix[c][r] = val;
         return val;
     }


}
public class TestMatrixM {
    public static void main(String[] args) throws Exception {

        // The Original Matrix
        System.out.println("\n Original matrix");
        Matrix matrix = new Matrix();

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                System.out.printf("%10d", matrix.MatrixM()[r][c]);
            }
            System.out.println("\n");
        }


        System.out.println("\nUpdated Matrix");
        int [][] NewMatrix = Matrix.UpdateMatrixVec(Matrix.MatrixM(), Matrix.Vectors2D());


        for(int r = 0; r< 6; r++) {
            for(int c = 0 ; c <7; c++){


                System.out.printf("%10d", NewMatrix[r][c]);
            }
            System.out.println("\n");
        }
        matrix.Write2DMatrix(NewMatrix);


    }

}
