package twodarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColumWiseSum {
    //[15, 10, 13, 16]
    public static void main(String[] args) {
        int[][] ar = {{1,2,3,4},
                      {5,6,7},
                      {9}};
        System.out.println(Arrays.toString(solve(ar)));
    }
    public static int[] solve(int[][] A) {
        List<Integer> sums = new ArrayList<>();
        int colSum;
        int col = 0;
        boolean atLeastOneColmn;
        do {
            atLeastOneColmn = false;
            colSum = 0;
            for(int i = 0 ; i < A.length ; i++) {
                if(col < A[i].length ) {
                    colSum += A[i][col];
                    atLeastOneColmn = true;
                }
            }
            if(atLeastOneColmn) {
                sums.add(colSum);
            }
            col++;
        }while(atLeastOneColmn);
        int[] finalresults = new int[sums.size()];
        for(int i = 0 ; i <sums.size() ; i++) {
            finalresults[i] = sums.get(i);
        }
        return  finalresults;
    }
}
