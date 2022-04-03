import java.util.Arrays;

public class RangeSum {

    public static void main(String[] args) {
        int[][] a = new int[4][3];
        System.out.println(Arrays.toString(rangeSum(new int[]{2, 2, 2},
                  new int[][]{{1, 1}, {2, 3}}
                )));
    }

    public static long[] rangeSum(int[] A, int[][] B) {
        int[] psE = new int[A.length];
        psE[0] = A[0];
        for(int i = 1; i< A.length; i++) {
            psE[i] = psE[i-1] +A[i];
        }

        long[] sumArray = new long[B.length];
        for(int j = 0; j< B.length ;j++) {
            int startIndex = B[j][0] - 1;
            int endIndex   = B[j][1] -1 ;
            sumArray[j]    = psE[endIndex] - (startIndex == 0? 0 : psE[startIndex-1]);
        }
        return sumArray;
    }
}
