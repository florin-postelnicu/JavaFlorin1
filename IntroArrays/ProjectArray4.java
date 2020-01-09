


public class ProjectArray4 {
    // Define a matrix as a bi-dimensional array


    public static void main(String[] args) {
        int[][] matrix = new int[4][2];
        for( int row = 0; row < 2; row++){
            for ( int col = 0; col < 4; col ++){
                matrix[col][row] = new java.util.Random().nextInt(12);
                System.out.printf("%5d", matrix[col][row]);
            }
            System.out.println("\n");
        }
    }

}
