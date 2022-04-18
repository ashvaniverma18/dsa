public class SumOfAllSubArraySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}));
    }

    public static long subarraySum(int[] A) {
        long totalSum = 0;
        int frequency = 0;
        for(int i = 0 ; i< A.length ; i++) {
            frequency = (A.length - i) * (i + 1);
            totalSum += frequency * A[i];
        }
        return  totalSum;
    }
}
