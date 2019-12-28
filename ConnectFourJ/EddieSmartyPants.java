


import java.util.ArrayList;
import java.util.List;


/** A very stupid computer player */
public class EddieSmartyPants implements IPlayer {
    private Token token;
    private Object List;

//    public EddieSmartyPants() {
//      Token[][] board;
//
//    }


    /**
     * Strategy is to chose a random column and select
     * the next valid column to the right (the chosen included)
     * @return
     */
    public Object getNextColumn(Token[][] board) {


        //TODO IMPROVE!
        /**
         * 1)Create a vector with all possible choices when is Eddie's move
         *
         * 2) Select the best move of the selection, and return that column
         *
         */





        if( board[3][0]==Token.empty){
            return 3;
        }



        else{

            java.util.Random generator = new java.util.Random();
            int col = generator.nextInt(board.length);
            int step = 0;
            while (isColFull(col, board)) {
                col = (col + 1) % board.length;
            }
            return col;
        }}
    public List<int []> EddieChoices(Token[][]board){
        List<int[]> path = new ArrayList<>();
        for(int row = 0; row <board[0].length; row ++){
            for( int col = 0; col < 7; col ++){
                if(isColFull(col, board)){
                    col++;

                }
                else if (board[col][row]!= Token.empty){
                    path.add(new int[]{row, col});
                    break;

                }
            }
        }
        return path;

    }
    public  int[] MaxEddieChoice(Token[][] board,List<int[]> vector){
        vector = EddieChoices(board);
        int max = 0;
        int row;
        int col;
        int[] array = new int[3];

        for (int[] ints : vector) {

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


    /**
     * @return true if the column col is already full and false otherwise.
     */
    private boolean isColFull(int col, Token[][] board) {
        int topRow = board[col].length - 1;
        return (board[col][topRow] != Token.empty);
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