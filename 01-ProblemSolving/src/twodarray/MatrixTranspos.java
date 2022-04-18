package twodarray;

public class MatrixTranspos {
    public static void main(String[] args) {
      int[][] aa =   {
                      {21, 62, 16, 44, 55, 100, 16},
                      {62, 72, 85, 35, 14, 1, 89 },
                      {42, 44, 30, 56, 25, 52, 61},
                      {5, 35, 12, 35, 55, 74, 50 },
                      {2, 65, 65, 82, 26, 36, 66} ,
                      {18, 1, 16, 91, 42, 11, 72 },
                      {23, 57, 9, 28, 13, 44, 40 }
                    };

      print(solve(aa));

    }

    public static int[][] solve(int[][] A) {
        int[][] result = new int[A.length][A[0].length];
        for(int i = 0 ; i < A.length ;i++) {
            int temp = 0;
            for(int j = i+1; j < A[0].length ; j++) {
                temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        return  A;
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
