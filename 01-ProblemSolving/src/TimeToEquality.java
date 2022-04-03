/**
 * Given an integer array A of size N. In one second, you can increase the value of one element by 1.
 *
 * Find the minimum time in seconds to make all elements of the array equal.
 * Example Input
 *
 * A = [2, 4, 1, 3, 2]
 *
 *
 * Example Output
 *
 * 8
 */
public class TimeToEquality {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{2, 4, 1, 3, 2}));
    }

    public static  int solve(int[] A) {
        int max = A[0];
        for(int i = 1; i < A.length ;i++) {
            if(A[i] >  max) {
                max = A[i];
            }
        }
        int totalTicks = 0;
        for(int i = 0; i < A.length ;i++) {
            totalTicks = totalTicks + (max - A[i]);
        }
        return totalTicks;
    }
}
