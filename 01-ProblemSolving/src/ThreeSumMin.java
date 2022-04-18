public class ThreeSumMin {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 6, 4, 2, 6, 9},
                new int[]{2, 5, 7, 3, 2, 7}));
    }

    public static int solve(int[] A, int[] B) {
        int sum = Integer.MAX_VALUE;
        int leftMin;
        int rightMin;
        for(int i = 1 ; i< A.length-1 ;i++) {
            leftMin  = leftMin(A,B,i);
            rightMin = rightMin(A,B,i);
            if(leftMin != -1 && rightMin != -1) {
                sum = Math.min(sum, leftMin+rightMin+B[i]);
            }
        }
        return sum == Integer.MAX_VALUE ? -1: sum;
    }

    public static int leftMin(int[] arr, int[] B, int s) {
        int min = -1;
        for(int i = s-1 ; i>=0 ;i--) {
            if(arr[s] > arr[i]) {
                min = min == -1 ? B[i] :Math.min(min, B[i]);
            }
        }
        return min;
    }

    public static int rightMin(int[] arr, int[] B, int s) {
        int min = -1;
        for(int i = s+1 ; i < arr.length ;i++) {
            if(arr[s] < arr[i]) {
                min = min == -1 ? B[i] :Math.min(min, B[i]);
            }
        }
        return min;
    }

}
