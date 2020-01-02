import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** A very stupid computer player */
public class ComputerPlayer implements IPlayer {
    private Token token;

    public boolean checkPossibility(Token[][] board, int col, int row)
    {
        //  Check horizontal
        //pos 1
        if ((col+3)<6 && board[col+1][row]!= Token.empty &&
                board[col+1][row]==board[col+2][row] &&
                board[col+2][row]==board[col+3][row])
            return true;
            //pos 2
        else if ((col+2)<6 && (col-1) >=0 && board[col+1][row]!= Token.empty &&
                board[col+1][row]==board[col+2][row] &&
                board[col+2][row]==board[col-1][row])

            return true;

            //pos 3
        else if ((col+1)<6 && (col-2) >=0 && board[col+1][row]!= Token.empty &&
                board[col+1][row]==board[col-1][row] &&
                board[col-1][row]==board[col-2][row])

            return true;

            //pos 4
        else if ((col-3) >=0 && board[col-1][row]!= Token.empty &&
                board[col-1][row]==board[col-2][row] &&
                board[col-2][row]==board[col-3][row])

            return true;


            //check down
        else if ( (row -3)>=0 && board[col][row-1]!= Token.empty &&
                board[col][row-1]==board[col][row-2] &&
                board[col][row-2]==board[col][row -3]){

            return true;
        }

// Check front slash

        //first position
        else if( (col+3)<7 && (row+3)<6 && board[col+1][row+1]!= Token.empty &&
                board[col+1][row +1]==board[col+2][row+2] &&
                board[col+2][row+2]==board[col+3][row+3]){

            return true;
        }
        //second position
        else if( (col+2)<7 && (row+2)<6 && (col-1)>=0 && (row-1)>=0 &&
                board[col+1][row+1]!= Token.empty &&
                board[col+1][row+1]==board[col+2][row+2] &&
                board[col+2][row+2]==board[col-1][row-1]){

            return true;
        }
        //third position
        else if( (col+1)<7 && (row+1)<6 && (col-2)>=0 && (row-2)>=0 &&
                board[col+1][row+1]!= Token.empty &&
                board[col+1][row+1]==board[col-1][row-1] &&
                board[col-1][row-1]==board[col-2][row-2]){

            return true;
        }

        //fourth position
        else if((col-3)>=0 && (row-3)>=0 &&
                board[col-1][row-1]!= Token.empty &&
                board[col-1][row-1]==board[col-2][row-2] &&
                board[col-2][row-2]==board[col-3][row-3]){

            return true;
        }

// check back slash

        //back pos 1
        else if ((col+3)<7 && (row-3) >=0 &&
                board[col+1][row-1]!= Token.empty &&
                board[col+1][row-1]==board[col+2][row-2] &&
                board[col+2][row-2]==board[col+3][row-3]){

            return true;
        }
        // back pos 2
        else if ((col+2)<7 && (row-2)>=0 && (col-1)>=0 && (row+1)<6 &&
                board[col+1][row-1]!= Token.empty &&
                board[col+1][row-1]==board[col+2][row-2] &&
                board[col+2][row-2]==board[col-1][row+1]){

            return true;
        }
        // back pos 3
        else if ((col+1)<7 && (row-1)>=0 && (col-2)>=0 && (row+2)<6 &&
                board[col+1][row-1]!= Token.empty &&
                board[col+1][row-1]==board[col-1][row+1] &&
                board[col-1][row+1]==board[col-2][row+2]){

            return true;
        }
        // back pos 4
        else return (col - 3) >= 0 && (row + 3) < 6 &&
                    board[col - 1][row + 1] != Token.empty &&
                    board[col - 1][row + 1] == board[col - 2][row + 2] &&
                    board[col - 2][row + 2] == board[col - 3][row + 3];
    }
    public static int[][] EddieMemory() throws Exception {
        int[][] myEddie;


        if(VierGewinnt.firstPlayer == 1){
            myEddie= MainConnect4.matrix1();

        }
        else{
            myEddie = MainConnect4.matrix2();
        }

        return myEddie;

    }

    public static List<int []> VectorChoices(int[][] eddieMemory, List<int []> eddieChoices){
        List<int []> myVectorChoices = new ArrayList<>();
        for (int[] eddieChoice : eddieChoices) {
            int valed = eddieMemory[eddieChoice[0]][eddieChoice[1]];
            int rowed = eddieChoice[0];
            int coled = eddieChoice[1];
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






    public Object getNextColumn(Token[][] board ) throws Exception {
        if(board[3][0]== Token.empty){
            return 3;

        }
        for (int col=0; col<7; col++){
            if (board[col][0] == Token.empty &&
                    this.checkPossibility(board, col, 0) ) {
                return col;

            }
        }
        for (int col=0; col<7; col++){
            for (int row=1; row<6; row++){
                if (board[col][row-1] != Token.empty && board[col][row] == Token.empty &&
                        this.checkPossibility(board, col, row) ) {
                    return col;

                }
            }
        }


        //TODO IMPROVE!


        System.out.println("I've been here!");
        MainConnect4 vg = new MainConnect4();
        int  col;
        col = MaxOlista1( VectorChoices(EddieMemory(),
                Collections.unmodifiableList(vg.EddieChoices(board))));

        while ( isColFull( col, board ) ) {
            col = ( col + 1 ) % board.length;
        }

        return col;
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