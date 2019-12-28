


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class VierGewinnt
{

    public static final int COLS = 7;
    public static final int ROWS = 6;
    boolean done ;

    private static Token[][] board = new Token[ COLS ][ ROWS ]; // 7 columns with 6 fields each
    private IPlayer[] players = new IPlayer[ 2 ]; // two players

    /** initialize board and players and start the game */
    public void play()
    {
        // initialize the board
        for ( Token[] column : this.board ) {
            Arrays.fill( column, Token.empty );
        }

        /* initialize players */
        players[ 0 ] = new HumanPlayer();
        System.out.print( "Play against a human opponent? (y / n) " );
        String opponent = new Scanner( System.in ).nextLine().toLowerCase();
        while ( ( 1 != opponent.length() ) || ( -1 == ( "yn".indexOf ( opponent ) ) ) ) {
            System.out.print( "Can't understand your answer. Play against a human opponent? (y / n) " );
            opponent = new Scanner( System.in ).nextLine().toLowerCase();
        }
        if ( opponent.equals( "y" ) ) {
            players[ 1 ] = new HumanPlayer();
        } else {
            players[ 1 ] = new ComputerPlayer();
        }
        players[ 0 ].setToken( Token.player1 );
        players[ 1 ].setToken( Token.player2 );

        /* play... */
        boolean solved = false;
        int currentPlayer = new java.util.Random().nextInt( 2 );  //choose randomly who begins
        System.out.println( "current player: " + currentPlayer );
        int insertCol, insertRow; // starting from 0
        while ( !solved && !this.isBoardFull() ) {
            // get player's next "move"
            // note that we pass only a copy of the board as an argument,
            // otherwise the player would be able to manipulate the board and cheat!
            insertCol = (int) players[ currentPlayer ].getNextColumn( getCopyOfBoard() );
            // insert the token and get the row where it landed
            insertRow = this.insertToken( insertCol, players[ currentPlayer ].getToken() );
            // check if the game is over
            solved = this.checkVierGewinnt( insertCol, insertRow );
            //switch to other player
            if ( !solved )
                currentPlayer = ( currentPlayer + 1 ) % 2;
        }
        System.out.println( displayBoard( board ) );
        if ( solved )
            System.out.println( "Player " + players[ currentPlayer ].getToken() + " wins!" );
        else
            System.out.println( "Draw! Game over." );
    }


    /*
     * Inserts the token at the specified column (if possible)
     * @param column the column to insert the token
     * @param token the players token
     * @return the row where the token landed
     */
    private int insertToken( int column, Token tok ) {
        //TODO: Your code goes here
        int retrow = -1;
        for (int row = 0; row <board[0].length ; row++) {
            if (board[column][row] == Token.empty ) {
                board[column][row] = tok;
                retrow = row;
                break;
            }
        }
//        ComputerPlayer cp = new ComputerPlayer();
//        cp.DisplayeddieChoices(cp.EddieChoices(board));
        return  retrow; //TODO: Replace this line
    }


    /**
     * Checks if every position is occupied
     * @returns true, iff the board is full.
     */
    private boolean isBoardFull() {
        //TODO: Your code goes here
        int topRow = board[0].length - 1;
        for (int column = 0; column < 7; column++) {
            if (board[column][topRow] == Token.empty) {
                return false;
            }
        }return true;
    }


    /**
     * Checks for at least four equal tokens in a row in
     * either direction, starting from the given position.
     */
    private boolean checkVierGewinnt( int col, int row )
    {
        //TODO: Your code goes here

        //  Check horizontal
        int winsHorizontal = 0;
        for (int i=0; i<4; i++)
            if (board[i][row] != Token.empty && board[i][row] ==board[i +1][row] &&
                    board[i +1 ][row]==board[i+2][row] && board[i+2][row]==board[i+3][row])
                winsHorizontal++;

        if (winsHorizontal != 0)
            return true;

            //check down
        else if ( (row -3)>=0 && board[col][row] ==board[col][row -1] &&
                board[col][row-1]==board[col][row-2] && board[col][row-2]==board[col][row -3]){

            return true;
        }

        // Check front slash

        //first position
        else if( (col+3)<7 && (row+3)<6 &&
                board[col][row]==board[col+1][row +1] &&
                board[col+1][row +1]==board[col+2][row+2] && board[col+2][row+2]==board[col+3][row+3]){

            return true;
        }
        //second position
        else if( (col+2)<7 && (row+2)<6 && (col-1)>=0 && (row-1)>=0 &&
                board[col][row]==board[col+1][row +1] &&
                board[col+1][row +1]==board[col+2][row+2] && board[col+2][row+2]==board[col-1][row-1]){

            return true;
        }
        //third position
        else if( (col+1)<7 && (row+1)<6 && (col-2)>=0 && (row-2)>=0 &&
                board[col][row]==board[col+1][row +1] &&
                board[col+1][row +1]==board[col-1][row-1] && board[col-1][row-1]==board[col-2][row-2]){

            return true;
        }

        //fourth position
        else if((col-3)>=0 && (row-3)>=0 &&
                board[col][row] ==board[col-1][row-1 ] &&
                board[col-1][row-1]==board[col-2][row-2] && board[col-2][row-2]==board[col-3][row-3]){

            return true;
        }

        // check back slash

        //back pos 1
        else if ((col+3)<7 && (row-3) >=0 &&
                board[col][row]==board[col+1][row-1] &&
                board[col+1][row-1]==board[col+2][row-2] && board[col+2][row-2]==board[col+3][row-3]){

            return true;
        }
        // back pos 2
        else if ((col+2)<7 && (row-2)>=0 && (col-1)>=0 && (row+1)<6 &&
                board[col][row]==board[col+1][row-1] &&
                board[col+1][row-1]==board[col+2][row-2] && board[col+2][row-2]==board[col-1][row+1]){

            return true;
        }
        // back pos 3
        else if ((col+1)<7 && (row-1)>=0 && (col-2)>=0 && (row+2)<6 &&
                board[col][row]==board[col+1][row-1] &&
                board[col+1][row-1]==board[col-1][row+1] && board[col-1][row+1]==board[col-2][row+2]){

            return true;
        }
        // back pos 4
        else if((col-3)>=0 && (row+3)<6 &&
                board[col][row] ==board[col-1][row +1] &&
                board[col-1][row+1]==board[col-2][row+2] && board[col-2][row+2]==board[col-3][row +3]){

            return true;
        }

        else
            return false; //TODO: Replace this line!}
    }


    /** Returns a (deep) copy of the board array */
    public static Token[][] getCopyOfBoard()
    {
        Token[][] copiedBoard = new Token[ COLS ][ ROWS ];
        for ( int i = 0; i < copiedBoard.length; i++ ) {
            System.arraycopy(VierGewinnt.board[i], 0, copiedBoard[i], 0, copiedBoard[i].length);
        }
        return copiedBoard;
    }


    /** returns a graphical representation of the board */
    public static String displayBoard( Token[][] myBoard )
    {
        String rowDelimiter = "+";
        String rowNumbering = " ";
        for ( int col = 0; col < myBoard.length; col++ ) {
            rowDelimiter += "---+";
            rowNumbering += " " + ( col + 1 ) + "  ";
        }
        rowDelimiter += "\n";

        String rowStr;
        String presentation = rowDelimiter;
        for ( int row = myBoard[ 0 ].length - 1; row >= 0; row-- ) {
            rowStr = "| ";
            for ( int col = 0; col < myBoard.length; col++ ) {
                rowStr += myBoard[ col ][ row ].toString() + " | ";
            }
            presentation += rowStr + "\n" + rowDelimiter;
        }
        presentation += rowNumbering;
        return presentation;
    }
    public List<int []> EddieChoices(Token[][] board) {
        ;
        final List<int[]> choices= new ArrayList<>();
        for (int col = 0; col < 7; col++) {

            for (int row = 0; row < 7; row++) {
                if (isColFull(col, board)) {
                    col++;
                } else if (board[col][row] == Token.empty) {

                    choices.add(new int[]{row, col});

                    break;
                }
            }

        }
        return choices;
    }
    private boolean isColFull(int col, Token[][] board) {
        int topRow = board[col].length - 1;
        return (board[col][topRow] != Token.empty);
    }
    /** main method, starts the program */
    public static void main( String args[] )
    {
        VierGewinnt game = new VierGewinnt();
//        game.DisplayEdChoices(game.board);
        game.play();



    }
}
