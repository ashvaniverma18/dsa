import java.util.Arrays;

public class PickFromBothSide {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{5, -2, 3 , 1, 2}, 3));
    }

    public static int solve(int[] A, int B) {
       int lsum = 0;
       for(int i = 0; i < B ;i++) {
           lsum += A[i];
       }
       int max = lsum;
       int lPtr = B-1;
       int rpt = A.length -1;
       while(lPtr >=0 ){
           lsum = lsum - A[lPtr];
           lsum = lsum + A[rpt];
           if(lsum > max) {
               max = lsum;
           }
           lPtr--;
           rpt--;
       }
       return max;

    }

}
