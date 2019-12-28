import java.util.ArrayList;
import java.util.List;

/** A very stupid computer player */
public class ComputerPlayer implements IPlayer {
    private Token token;



    /**
     * Strategy is to chose a random column and select
     * the next valid column to the right (the chosen included)
     * @return
     */
    public Object getNextColumn(Token[][] board) {


        //TODO IMPROVE!
        /**
         * Here should be called EddieChoices to decide upon the next move for Eddie
         * The DisplayEddieChoices is just for checking
         */


        VierGewinnt vg = new VierGewinnt();
        DisplayEddieChoices(vg.EddieChoices(board));

        if( board[3][0]==Token.empty){
//            DisplayeddieChoices(EddieChoices(board));
            return 3;
        }




        else{

            java.util.Random generator = new java.util.Random();

            int col = generator.nextInt(board.length);
            int step = 0;
            while (isColFull(col, board)) {
                col = (col + 1) % board.length;
            }
//            DisplayeddieChoices(EddieChoices(board));
            return col;
        }

    }


    /**
     * @return true if the column col is already full and false otherwise.
     */
    private boolean isColFull(int col, Token[][] board) {
        int topRow = board[col].length - 1;
        return (board[col][topRow] != Token.empty);
    }
//    public List<int []> EddieChoices(Token[][] board) {
//        ;
//        final List<int[]> choices= new ArrayList<>();
//        for (int col = 0; col < 7; col++) {
//            ;
//
//            for (int row = 0; row < 7; row++) {
//                if (isColFull(col, board)) {
//                    col++;
//                } else if (board[col][row] == Token.empty) {
//
//                    choices.add(new int[]{row, col});
//
//                    break;
//                }
//            }
//
//        }
//        return choices;
//    }


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