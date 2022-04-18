package twodarray;

public class MatricesMultiplication {

    public static void main(String[] args) {
        /*int[][] A = {{1, 2}, {3, 4}};

        int[][] B = {{5, 6}, {7, 8}};*/

        int[][] A = {{1, 1}};

        int[][] B = {{2}, {3}};

        print(solve(A, B));
    }

    public static void print(int[][] matrx) {
        for (int r = 0; r < matrx.length; r++) {       //for loop for row iteration.
            for (int c = 0; c < matrx[r].length; c++) {   //for loop for column iteration.
                System.out.print(matrx[r][c] + " ");
            }
            System.out.println("");
        }

    }


    public static int[][] solve(int[][] A, int[][] B) {
        int[][] multiArray = new int[A.length][B[0].length];
        int col = 0;
        int sum;
        while (col < B[0].length) {
            for (int i = 0; i < A.length; i++) {
                sum = 0;
                for (int j = 0; j < A[0].length; j++) {
                    sum += A[i][j] * B[j][col];
                }
                multiArray[i][col] = sum;
            }
            col++;
        }

        return multiArray;
    }
}
