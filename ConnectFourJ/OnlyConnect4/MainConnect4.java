




import java.io.*;
import java.util.*;


public class MainConnect4
{

    public static final int COLS = 7;
    public static final int ROWS = 6;

    boolean  EddiePlayer = false;
    public static int firstPlayer;

    private static Token[][] board = new Token[ COLS ][ ROWS ]; // 7 columns with 6 fields each
    private IPlayer[] players = new IPlayer[ 2 ]; // two players

    public MainConnect4() throws Exception {
    }

    // generic reader of a matrix from a file by providing filename

    public static int[][] ReadMatrix(String filename) throws Exception {
        int[][] myArray;
        FileReader fr = new FileReader(filename);
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

        return myArray;
    }
    int[][] Matrix1 = ReadMatrix("C://Users/postelnicu/IdeaProjects/Connect4Project/src/matrix1.txt");
    int[][] Matrix2 = ReadMatrix("C://Users/postelnicu/IdeaProjects/Connect4Project/src/matrix2.txt");
    int[][] Win1 = ReadMatrix("C://Users/postelnicu/IdeaProjects/Connect4Project/src/win1.txt");
    int[][] Win2 = ReadMatrix("C://Users/postelnicu/IdeaProjects/Connect4Project/src/win2.txt");
    int[][] Loss1 = ReadMatrix("C://Users/postelnicu/IdeaProjects/Connect4Project/src/loss1.txt");
    int[][] Loss2 = ReadMatrix("C://Users/postelnicu/IdeaProjects/Connect4Project/src/loss2.txt");


    // Generic write to the file any matrix


    public static void Write2FileMatrix(int [][] matrix, String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                sb.append(matrix[r][c]).append("   ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();


    }




    // Generic print any matrix

    public static void WriteZMatrix(int[][] matrix){
        for (int[] ints : matrix) {
            for (int row = 0; row < matrix[0].length; row++) {
                System.out.printf("%7d", ints[row]);

            }
            System.out.println("\n");
        }
    }



    public static int[][] matrix2() throws Exception {
        int[][] myArray;
        FileReader fr = new FileReader("C://Users/postelnicu/IdeaProjects/Connect4Project/src/matrix2.txt");
        Scanner sc = new Scanner(new BufferedReader(fr));

        int rows = 6;
        int columns = 7;
        myArray = new int[rows][columns];
        while (sc.hasNextLine()) {
            // Split in lines; number of lines = size of array
            for (int i = 0; i < myArray.length; i++) {
                String[] line = sc.nextLine().trim().split(" {3}");
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

    public static int[][] matrix1() throws Exception {
        int[][] myArray;
        FileReader fr = new FileReader("C://Users/postelnicu/IdeaProjects/Connect4Project/src/matrix1.txt");
        Scanner sc = new Scanner(new BufferedReader(fr));


        int rows = 6;
        int columns = 7;
        myArray = new int[rows][columns];
        while (sc.hasNextLine()) {
            // Split in lines; number of lines = size of array
            for (int i = 0; i < myArray.length; i++) {
                String[] line = sc.nextLine().trim().split(" {3}");
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



    public static int[][] UpdateMatrixVec(int[][] Matrix, List<int[]> vec, int increment) {

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++)
                for (int[] ints : vec)
                    if (row == ints[0] && col == ints[1]) Matrix[row][col] = Matrix[row][col] +  increment;
                    else Matrix[row][col] = Matrix[row][col];
        }
        return Matrix;

    }

    public void Write2DMatrix2(int[][] matrixes) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C://Users/postelnicu/IdeaProjects/Connect4Project/src/matrix2.txt")));

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

    public void Write2DMatrix1(int[][] matrixes) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C://Users/postelnicu/IdeaProjects/Connect4Project/src/matrix1.txt")));

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

    public static int[] BackTracking(int [][]matrix,  List<int []> vec){
        int[] punish = new int[3];
        int count = vec.size() -1;
        for(int i = count; i>= 0; i--){
            int rowp = vec.get(i)[0];
            int colp = vec.get(i)[1];
            if(matrix[rowp][colp] != 0){
                int valp = matrix[rowp][colp];
                punish[0] = rowp;
                punish[1] = colp;
                punish[2] = valp;
                break;
            }

        }
        // Attn to all are zeros
        return punish;
    }


    /** initialize board and players and start the game */
    public void play() throws Exception {


        // The starting matrices
        System.out.println(" Matrix 1 ");

        for( int row = 0; row<6; row++){
            for(int col = 0; col< 7; col++){
                System.out.printf("%10d", matrix1()[row][col]);
            }
            System.out.println("\n");
        }

        System.out.println(" Matrix 2");
        for( int row = 0; row<6; row++){
            for(int col = 0; col< 7; col++){
                System.out.printf("%10d", matrix2()[row][col]);
            }
            System.out.println("\n");
        }
        // Vectors to keep the paths for Player0 and Player1


        List<int[]> Path2= new ArrayList<>();

        List<int[]> Path1 = new ArrayList<>();

        List<int[]> PathStart = new ArrayList<>();
        // initialize the board
        for ( Token[] column : board ) {
            Arrays.fill( column, Token.empty );
        }

        /* initialize players */
        players[ 0 ] = new HumanPlayer();
//        players[0] = new ComputerPlayer();
//        players[1] = new ComputerPlayer();
        System.out.print( "Play against a human opponent? (y / n) " );
        String opponent = new Scanner( System.in ).nextLine().toLowerCase();
        while ( ( 1 != opponent.length() ) || (!"yn".contains(opponent)) ) {
            System.out.print( "Can't understand your answer. Play against a human opponent? (y / n) " );
            opponent = new Scanner( System.in ).nextLine().toLowerCase();
        }
        if ( opponent.equals( "y" ) ) {
            players[ 1 ] = new HumanPlayer();
        } else {
            players[ 1 ] = new ComputerPlayer();
            EddiePlayer = true;
        }
        players[ 0 ].setToken( Token.player1 );
        players[ 1 ].setToken( Token.player2 );

        /* play... */
        boolean solved = false;
        int currentPlayer = new java.util.Random().nextInt( 2 );  //choose randomly who begins
        firstPlayer = currentPlayer;
        System.out.println( "current player: " + currentPlayer );

        int insertCol, insertRow; // starting from 0
        // Starting from a given position
        // Use the Path1 and Path2 from the previous game,
        //recorded as a single vector, with all the moves saved in order of
        // their occurrence
        while ( !solved && !this.isBoardFull() ) {
            // get player's next "move"
            // note that we pass only a copy of the board as an argument,
            // otherwise the player would be able to manipulate the board and cheat!



            /*
            Insert here the starting moves.
            It will start with all the moves in the PathStart, and
            backtracking each time it is a win, such that the best
            solution is discovered
             */


            insertCol = (int) players[ currentPlayer ].getNextColumn( getCopyOfBoard() );
            // insert the token and get the row where it landed
            insertRow = this.insertToken( insertCol, players[ currentPlayer ].getToken() );
            System.out.println("CurrentPlayer : Player" +currentPlayer+ "  col :" +insertCol + "  row : "+ insertRow);


            if(currentPlayer== firstPlayer ){
                Path1.add(new int[]{insertRow, insertCol});
            }
            else{
                Path2.add(new int[]{insertRow, insertCol});
            }
            // check if the game is over
            solved = this.checkWin( insertCol, insertRow );//checkwin

            //switch to other player
            if ( !solved )
                currentPlayer = ( currentPlayer + 1 ) % 2;

        }
        System.out.println( displayBoard( board ) );
        if ( solved ) {

            System.out.println("Player " + players[currentPlayer].getToken() + " wins!");
            System.out.println("FirstPlayer  :" + firstPlayer);
            if(currentPlayer == firstPlayer){
                UpdateMatrixVec(matrix1(),Path1, 1);
                int [][] UpWin1 = UpdateMatrixVec(Win1, Path1, 1);
                int[][] UpLoss2  = UpdateMatrixVec(Loss2, Path2, -1);
                Write2FileMatrix(UpWin1, "C://Users/postelnicu/IdeaProjects/Connect4Project/src/win1.txt");
                WriteZMatrix(UpWin1);
                Write2FileMatrix(UpLoss2, "C://Users/postelnicu/IdeaProjects/Connect4Project/src/loss2.txt");
                WriteZMatrix(UpLoss2);

                for( int row = 0; row<6; row++){
                    for(int col = 0; col< 7; col++){
                        System.out.printf("%10d", UpdateMatrixVec(matrix1(), Path1, 1)[row][col]);
                    }
                    System.out.println("\n");
                }
                Write2DMatrix1(UpdateMatrixVec(matrix1(),Path1, 1));

                // Call Backtracking for matrix2(), and Path2



                // Attempt to get punished for loosing

                int rowp2b = BackTracking(matrix2(), Path2)[0];
                int colp2b = BackTracking(matrix2(), Path2)[1];
                int decrp2b = -BackTracking(matrix2(), Path2)[2];
                System.out.println("Row :" + rowp2b + "  Col : " + colp2b + "  value  :" + decrp2b );

                Write2DMatrix2(UpdateMatrixVec(matrix2(), Collections.singletonList(new int[]{rowp2b, colp2b}), decrp2b));


                for( int row = 0; row<6; row++){
                    for(int col = 0; col< 7; col++){
                        System.out.printf("%10d", matrix1()[row][col]);
                    }
                    System.out.println("\n");
                }

                DisplayPath(Path1);
                DisplayPath(Path2);}
            else{
                UpdateMatrixVec(matrix2(), Path2, 1);
                int [][] UpWin2 = UpdateMatrixVec(Win2, Path2, 1);
                WriteZMatrix(UpWin2);
                Write2FileMatrix(UpWin2, "C://Users/postelnicu/IdeaProjects/Connect4Project/src/win2.txt");
                int [][] UpLoss1 = UpdateMatrixVec(Loss1,  Path1, -1);
                Write2FileMatrix(UpLoss1, "C://Users/postelnicu/IdeaProjects/Connect4Project/src/loss1.txt");
                WriteZMatrix(UpLoss1);

                for( int row = 0; row<6; row++){
                    for(int col = 0; col< 7; col++){
                        System.out.printf("%10d", UpdateMatrixVec(matrix2(), Path2, 1)[row][col]);
                    }
                    System.out.println("\n");
                }
                Write2DMatrix2(UpdateMatrixVec(matrix2(), Path2, 1) );

                // Call Backtracking for matrix1(), and Path1


                int rowp1b = BackTracking(matrix1(), Path1)[0];
                int colp1b = BackTracking(matrix1(), Path1)[1];
                int decrp1b = -BackTracking(matrix1(), Path1)[2];
                System.out.println("Row :" + rowp1b + "  Col : " + colp1b + "  value  :" + decrp1b );
                Write2DMatrix1(UpdateMatrixVec(matrix1(), Collections.singletonList(new int[]{rowp1b, colp1b}), decrp1b));

//                Write2DMatrix1(UpdateMatrixVec(matrix1(), Collections.singletonList(new int[]{rowp1, colp1}), decrp1));

                for( int row = 0; row<6; row++){
                    for(int col = 0; col< 7; col++){
                        System.out.printf("%10d", matrix2()[row][col]);
                    }
                    System.out.println("\n");
                }

                DisplayPath(Path1);
                DisplayPath(Path2);
            }

        }
        else{
            System.out.println( "Draw! Game over." );
        }
    }


    /*
     * Inserts the token at the specified column (if possible)
     * @param column the column to insert the token
     * @param token the players token
     * @return the row where the token landed
     */
    private int insertToken( int column, Token tok ) {

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
        return  retrow;
    }


    /**
     * Checks if every position is occupied
     * @returns true, iff the board is full.
     */
    private boolean isBoardFull() {

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
    private boolean checkWin( int col, int row )// checkwin
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
        else //TODO: Replace this line!}
            if ((col+1)<7 && (row-1)>=0 && (col-2)>=0 && (row+2)<6 &&
                    board[col][row]==board[col+1][row-1] &&
                    board[col+1][row-1]==board[col-1][row+1] && board[col-1][row+1]==board[col-2][row+2]){

                return true;
            }
            // back pos 4
            else return (col - 3) >= 0 && (row + 3) < 6 &&
                    board[col][row] == board[col - 1][row + 1] &&
                    board[col - 1][row + 1] == board[col - 2][row + 2] && board[col - 2][row + 2] == board[col - 3][row + 3];
    }


    /** Returns a (deep) copy of the board array */
    public static Token[][] getCopyOfBoard()
    {
        Token[][] copiedBoard = new Token[ COLS ][ ROWS ];
        for ( int i = 0; i < copiedBoard.length; i++ ) {
            System.arraycopy(MainConnect4.board[i], 0, copiedBoard[i], 0, copiedBoard[i].length);
        }
        return copiedBoard;
    }


    /** returns a graphical representation of the board */
    public static String displayBoard( Token[][] myBoard )
    {
        String rowDelimiter = "+";
        StringBuilder rowNumbering = new StringBuilder(" ");
        for ( int col = 0; col < myBoard.length; col++ ) {
            rowDelimiter += "---+";
            rowNumbering.append(" ").append(col + 1).append("  ");
        }
        rowDelimiter += "\n";

        StringBuilder rowStr;
        StringBuilder presentation = new StringBuilder(rowDelimiter);
        for ( int row = myBoard[ 0 ].length - 1; row >= 0; row-- ) {
            rowStr = new StringBuilder("| ");
            for (Token[] tokens : myBoard) {
                rowStr.append(tokens[row].toString()).append(" | ");
            }
            presentation.append(rowStr).append("\n").append(rowDelimiter);
        }
        presentation.append(rowNumbering);
        return presentation.toString();
    }
    public List<int []> EddieChoices(Token[][] board) {

        final List<int[]> choices= new ArrayList<>();
        for (int col = 0; col < 7; col++) {


            for (int row = 0; row < 6; row++) {
                if (!isColFull(col, board)) {
                    if (board[col][row] == Token.empty) {

                        choices.add(new int[]{row, col});

                        break;
                    }
                } else {
                    col++;
                    if(col>= 7){
                        break;
                    }
                }
            }

        }
        return choices;
    }
    private boolean isColFull(int col, Token[][] board) {
        int topRow = board[col].length - 1;
        return (board[col][topRow] != Token.empty);
    }
    public void DisplayPath(List<int[]> path){
        for (int[] ints : path) System.out.println("row : " + ints[0] + "  col : " + ints[1]);
    }
    /** main method, starts the program */
    public static void main(String[] args) throws Exception {

        MainConnect4 game = new MainConnect4();
//        game.DisplayEdChoices(game.board);
        System.out.println("First Eddie vs Eddie game!");
        game.play();




    }
}