public class NumberOfSubArrayLessThanGivenSum {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{2, 5, 6},10));
    }

    public static int solve(int[] arr, int sum) {
        int currentsum = arr[0], begin = 0, i;

        // Always start with the initial index of an array
        int n = arr.length;
        int count = 0;
        for (i = 1; i <= n; i++) {
            // If currentsum exceeds the sum,
            // then remove the starting elements
            while (currentsum > sum && begin < i) {
                currentsum = currentsum - arr[begin];
                begin++;
            }

            if(currentsum < sum && currentsum != 0) {
                count++;
            }

            // If currentsum becomes equal to sum,
            // Add this element to currentsum
            if (i < n)
                currentsum = currentsum + arr[i];
        }
        return count;
    }
}
