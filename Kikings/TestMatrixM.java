

import sun.rmi.runtime.NewThreadAction;

import java.io.PrintStream;
import java.util.*;

 class MatrixM {



    //Read to the Matrix

    // I am creating a Temp matrix

    public static int[][] MatrixM(){
        int[][] Matrix = new int[6][7];
        for(int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
               Matrix[row][col] = 0;
        }
    }
    return Matrix;
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

        for( int index = 0; index<  vec.size(); index ++){
            for(int row = 0; row <6; row++){
                for(int col = 0; col <7; col++){
                    if(row != vec.get(index)[0] || col != vec.get(index)[1]){
                        Matrix[row][col] = Matrix[row][col] ;

                    }else{
                        System.out.println(vec.get(index)[0]  + "    "+ vec.get(index)[1]);
                        System.out.println("Yep");
                        Matrix[row][col] = Matrix[row][col] +1;
                        System.out.println("Matrix Entry   " + Matrix[row][col]);
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
    public static void main(String[] args) {
        MatrixM matrix = new MatrixM();

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                System.out.printf("%10d", matrix.MatrixM()[r][c]);
            }
            System.out.println("\n");
        }
        Vector<Integer> vec = new Vector<>();
        vec.add(0, matrix.MatrixM()[0][0] + 8);
        vec.add(1, matrix.MatrixM()[0][1] + 7);
        vec.add(2, matrix.MatrixM()[0][2] + 1);

        MatrixM.SetEntry1(MatrixM.MatrixM(), 0, 0, vec.get(0));


        MatrixM.SetEntry1(MatrixM.MatrixM(), 0, 1, vec.get(1));


        MatrixM.SetEntry1(MatrixM.MatrixM(), 0, 2, vec.get(2));

        System.out.println("\n\nNew Matrix");

        for(int r = 0; r< 6; r++) {
            for(int c = 0 ; c <7; c++){


            System.out.printf("%10d",MatrixM.UpdateMatrix(MatrixM.MatrixM(), 0, 0, vec.get(0))[r][c]);
        }
            System.out.println("\n");
        }

        MatrixM.UpdateMatrix(MatrixM.MatrixM(), 0, 0, vec.get(0));
        System.out.println("\nSecond Iteration");
        int [][] NewMatrix = MatrixM.UpdateMatrixVec(MatrixM.MatrixM(), MatrixM.Vectors2D());


        for(int r = 0; r< 6; r++) {
            for(int c = 0 ; c <7; c++){


                System.out.printf("%10d", NewMatrix[r][c]);
            }
            System.out.println("\n");
        }

    }
}
