
import java.util.*;




public class LinkedListEx {


    private static int SetEntry(int[][]Matrix,int c, int r, int val){
        Matrix[c][r] = val;
        return val;
    }

    private static int[][] UpdateMatrix(int[][] Matrix,int r, int c, int val){
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


    public  static int[] Viky(int[][] Matrix,int rov,int clov) {
        int[] ar = new int[3];
        ar[0] =  (int)Matrix[rov][clov];
        ar[1] = rov;
        ar[2] = clov;
        return ar;
    }







    public static int[] MaxOlista(List<int[]> vec){
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

    public static void main(String[] args) {

        // Creating a Matrix as rowXcolumn array
//

            int Matrix [][] = new int[6][7];
            for (int row = 0; row < 6; row++) {
                for (int col = 0; col < 7; col++) {
//
                    Matrix[row][col] = 0;
                }
            }





        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                System.out.printf("%10d", Matrix[r][c]);
            }
            System.out.println("\n");
        }
        // vec holds the increase in value of some specific entries
        // This should be a vector holding the updates in the values of the
        //Matrix after the end of a game.
        //All the entries in the path will be updated with a +1 value, if this is the winning path
        Vector<Integer> vec = new Vector<>();
        vec.add(0, Matrix[0][0] +8);
        vec.add(1, Matrix[0][1] +7);
        vec.add(2, Matrix[0][2] +1);

        Enumeration<Integer> en = vec.elements();
        System.out.println("\nVector's Elements");
        while(en.hasMoreElements()){
            System.out.println(en.nextElement());
        }

        // Changing an Entry of the matrix to a new value
        SetEntry(Matrix, 0,0, vec.get(0));


        SetEntry(Matrix,0,1, vec.get(1));


        SetEntry(Matrix,0,2,vec.get(2));

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                System.out.printf("%10d", Matrix[r][c]);
            }
            System.out.println("\n");
        }

        // Viky creates a tuple with three components:
        // for a given Entry , it holds (Value = entry, row, column)
        System.out.println("The Value is :   " + Viky(Matrix,0,0)[0] +"  at Row :  "+Viky(Matrix,0,0)[1] + "  and Column  : "+ Viky(Matrix,0,0)[2]);


        List<int[]> Victor = new ArrayList<>();
        Victor.add(0, new int[]{Matrix[0][0], 0, 0});
        Victor.add(1, new int[]{Matrix[0][1], 0,1});
        Victor.add(2, new int[]{Matrix[0][2], 0, 2});

//        int max = 0;
//        int row =0;
//        int col = 0;
        System.out.println("\nUsing a direct method VIctor");

        for(int i = 0; i < Victor.size(); i++){
             System.out.println(Victor.get(i)[0] +"  " +  Victor.get(i)[1]+"  " + Victor.get(i)[2]);

        }
        System.out.println("\nUsing Olista");

        System.out.println("Max value is :  " + MaxOlista( Victor)[0] +", Row :  "+ MaxOlista(Victor)[1]+ ",  Column  :"+ MaxOlista(Victor)[2] );




    }
}
