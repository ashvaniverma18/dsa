package twodarray;

public class Matrcies2DEquality {

    public static void main(String[] args) {

    }

    public static int solve(int[][] A, int[][] B) {
        for(int i = 0 ; i < A.length ;i++) {
            for(int j = 0; j < A[0].length ; j++) {
                if(A[i][j] != B[i][j]) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static int[][] multipli(int[][] A, int B) {
        int[][] result = new int[A.length][A[0].length];
        for(int i = 0 ; i < A.length ;i++) {
            for(int j = 0; j < A[0].length ; j++) {
                result[i][j] = A[i][j] * B;
            }
        }
        return result;
    }

    public static int minorDigonal(final int[][] A) {
        int sum = 0;
        int row = 0;
        int col = A[0].length -1;
        while(row < A.length && col >=0 ){
            sum += A[row++][col--];
        }
        return sum;
    }

    public static int[] rowSum(final int[][] A) {
        int[] rowSum = new int[A.length];
        for(int i = 0; i < A.length ; i++) {
            for(int j = 0; j <A[0].length ; j++) {
                rowSum[i] += A[i][j];
            }
        }
        return rowSum;
    }

    public static int majorDigonalSum(final int[][] A) {
        int sum = 0;
        for(int i = 0; i < A.length ; i++) {
            sum += A[i][i];
        }
        return sum;
    }

}
