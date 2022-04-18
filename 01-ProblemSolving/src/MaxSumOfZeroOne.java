public class MaxSumOfZeroOne {

    public static void main(String[] args) {
        //int[] arr = new int[]{1,1,1,1,1,0,0,1,0,1};
        String A = "1101001100101110";
        System.out.println(solve(A));
    }

    public static int solve(String A) {
        int[] arr = new int[A.length()];

        int totalOnes =0 ;

        for(int i = 0; i < A.length() ;i++) {
            if(A.charAt(i) == '1') {
                arr[i] = 1;
                totalOnes++;
            }else {
                arr[i] = 0;
            }
        }

        if(A.length() == totalOnes || totalOnes == 0) {
            return totalOnes;
        }

        int left;
        int right;
        int ans = 0;
        for(int i = 0 ; i< arr.length ;i++) {
            if(arr[i] == 0) {
                left = leftSum(arr, i-1);
                right = rightSum(arr, i+1);
                ans = Math.max(ans, (totalOnes > left + right ? left + right +1 : left + right));
            }
        }
        return ans;
    }

    public static int leftSum(int[] arr, int s) {
        int leftSum = 0;
        for(int i = s ; i >= 0 ; i--) {
            if(arr[i] == 1) {
                leftSum++;
            }else{
                break;
            }
        }
        return leftSum;
    }

    public static int rightSum(int[] arr, int s) {
        int rightSum = 0;
        for(int i = s ; i < arr.length ; i++) {
            if(arr[i] == 1) {
                rightSum++;
            }else{
                break;
            }
        }
        return rightSum;
    }

}

