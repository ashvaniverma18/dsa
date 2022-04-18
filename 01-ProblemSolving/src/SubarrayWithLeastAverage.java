public class SubarrayWithLeastAverage {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18}, 6));
        System.out.println(solve(new int[]{20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11}, 9));
    }

    //Brute force approach
/*
    public static int solve(int[] A, int B) {
        long sumArray;
        int index =0;
        long lastMinValue = Long.MAX_VALUE;
        for(int i = 0 ; i<= A.length - B ; i++) {
            sumArray = 0;
            for(int j = i ; j < i+B ;j++) {
                sumArray += A[j];
            }
            System.out.println(sumArray);
            if(sumArray < lastMinValue) {
                lastMinValue = sumArray;
                index = i;
            }
        }
        return index;
    }
*/

    public static int solve(int[] A, int B) {
        int index =0;
        long currentSubArraySum = 0;
        long lastMinSubArraySum = Long.MAX_VALUE;
        for(int i = 0 ; i <= A.length ; i++) {
            if( i >= B ) {
                if(currentSubArraySum < lastMinSubArraySum) {
                    index = i - B;
                    lastMinSubArraySum = currentSubArraySum;
                }
                currentSubArraySum    = currentSubArraySum - A[i-B];
            }
            if(i != A.length) {
                currentSubArraySum   += A[i];
            }
        }
        return index;
    }

}
