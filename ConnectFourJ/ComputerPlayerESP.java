
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** A very stupid computer player */
public class ComputerPlayerESP implements IPlayer {
    private Token token;
    public static int[][] EddieMemory() throws Exception {
        int[][] myEddie;


        if(VierGewinnt.firstPlayer == 1){
            myEddie= VierGewinnt.matrix1();

        }
        else{
            myEddie = VierGewinnt.matrix2();
        }

        return myEddie;

    }

    public static List<int []> VectorChoices(int[][] eddieMemory, List<int []> eddieChoices){
        List<int []> myVectorChoices = new ArrayList<>();
        for(int indx = 0; indx < eddieChoices.size(); indx++){
            int valed = eddieMemory[eddieChoices.get(indx)[0]][eddieChoices.get(indx)[1]];
            int rowed = eddieChoices.get(indx)[0];
            int coled = eddieChoices.get(indx)[1];
            myVectorChoices.add(new int[]{valed, rowed, coled});
        }

        return myVectorChoices;
    }
    public static int MaxOlista1(List<int[]> vec) {
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
        return array[2];
    }





    /**
     * Strategy is to chose a random column and select
     * the next valid column to the right (the chosen included)
     * @return
     */
    public Object getNextColumn(Token[][] board) throws Exception {


        //TODO IMPROVE!
        /**
         * Here should be called EddieChoices to decide upon the next move for Eddie
         * The DisplayEddieChoices is just for checking
         *
         * 1) EddieChoices will give the  Vector  VectorChoices{val, row,col} of the selected entries in EddieMemory matrix
         *
         * 2) MaxOlist would be applied to this new vector
         * and return the column corresponding to the max val .
         */


        VierGewinnt vg = new VierGewinnt();
        DisplayEddieChoices(Collections.unmodifiableList(vg.EddieChoices(board)));
        VectorChoices(EddieMemory(), vg.EddieChoices(board));
        final int col1 = MaxOlista1( VectorChoices(EddieMemory(), vg.EddieChoices(board)));
        return col1;




    }


    /**
     * @return true if the column col is already full and false otherwise.
     */
    private boolean isColFull(int col, Token[][] board) {
        int topRow = board[col].length - 1;
        return (board[col][topRow] != Token.empty);
    }


    public void DisplayEddieChoices(List<int []> Choices){
        for(int index = 0; index < Choices.size(); index++)
            System.out.println("col : " + Choices.get(index)[1] + "  row  :" + Choices.get(index)[0]);
    }



    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return this.token;
    }

    public String getPlayersName() {
        return "Random Player";
    }
}