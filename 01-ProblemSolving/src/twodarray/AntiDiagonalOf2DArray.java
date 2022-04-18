package twodarray;

public class AntiDiagonalOf2DArray {


    public static void main(String[] args) {
        print2D(diagonal(new int[][]{{1, 2 ,3,4},{5,6,7,8},{9, 10, 11,12},{13, 14, 15,16}}));
    }
    public static int[][] diagonal(int[][] A) {
        int[][] antiDigonalArrray = new int[2* A.length -1][A.length];
        int row = 0;
        int col = 0;
        int resultRow = 0;
        int resultCol = 0;
        for(int j = 0 ; j < A[0].length ; j++) {
            row = 0;
            col = j;
            while(row < A.length && col >= 0) {
                antiDigonalArrray[resultRow][resultCol] = A[row][col];
                resultCol++;
                row++;
                col--;
            }
            resultRow++;
            resultCol = 0;
        }
        for(int i = 1; i < A.length ;i++) {
            row = i;
            col = A[i].length -1 ;
            while(row < A.length && col >= 0) {
                antiDigonalArrray[resultRow][resultCol] = A[row][col];
                row++;
                col--;
                resultCol++;
            }
            resultRow++;
            resultCol = 0;
        }

        return antiDigonalArrray;
    }


    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
