public class MaximumSubarraySum {
    public static void main(String[] args) {
        //System.out.println(maxSubarray(0, 78, new int[]{7, 1, 8, 5, 8, 5, 3, 3, 5}));
        System.out.println(maxSubarray(0, 7, new int[]{3, 8, 8, 9, 7}));
        //3, 8, 8, 9, 7
    }

    public static int maxSubarray(int A, int B, int[] C) {
        int sum = 0;
        int maxSum = 0;
        int[] ps = new int[C.length];
        ps[0] = C[0];
        for(int i = 1;  i < C.length ; i++) {
            ps[i] = ps[i-1] + C[i];
        }
        for(int s = 0 ; s < C.length ; s++) {
            for(int e = s; e< C.length ; e++) {
                sum = (s == 0 ? ps[e] : ps[e] - ps[s - 1]);
                if(sum <= B) {
                    if(sum > maxSum)
                        maxSum = sum;
                }
            }

        }
        return maxSum;
    }
}
