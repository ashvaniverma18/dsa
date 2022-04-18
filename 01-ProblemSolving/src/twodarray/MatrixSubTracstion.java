package twodarray;

public class MatrixSubTracstion {

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[][] B = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        print(solve(A, B));
    }

    public static int[][] solve(int[][] A, int[][] B) {
        int numOfCol = A[0].length;
        int[][] resultArray = new int[A.length][A[0].length];

        for(int i = 0 ; i< A.length ; i++) {
            for(int j = 0; j < numOfCol ; j++) {
                resultArray[i][j] =  A[i][j] - B[i][j];
            }
        }
        return  resultArray;
    }

    public static void print(int[][] matrx) {
        for (int r = 0; r < matrx.length; r++) {       //for loop for row iteration.
            for (int c = 0; c < matrx[r].length; c++) {   //for loop for column iteration.
                System.out.print(matrx[r][c] + " ");
            }
            System.out.println("");
        }

    }
}
