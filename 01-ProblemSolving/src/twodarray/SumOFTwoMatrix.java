package twodarray;

import java.util.Arrays;

public class SumOFTwoMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}},
                new int[][]{{9, 8, 7},{6, 5, 4},{3, 2, 1}}
                )));
        }

    public static int[][] solve(int[][] A, int[][] B) {
        int[][] resultArray = new int[A.length][];
        for(int i = 0 ; i < A.length ; i++) {
            resultArray[i] = new int[A[i].length];
            for(int j = 0 ; j < A[i].length ; j++) {
                resultArray[i][j] = A[i][j] + B[i][j];
            }
        }
        return resultArray;
    }


}
