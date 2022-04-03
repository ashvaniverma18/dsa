public class EqualSumOfOddAndEven {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,5,2}));

    }

    public static int solve(int[] A) {
        int[] psE = new int[A.length];
        int[] psO = new int[A.length];
        psE[0] = A[0];
        psO[0] = 0;
        for(int i = 1 ; i < A.length ; i++) {
            psE[i] = psE[i-1] + (i%2 ==0 ? A[i] :0);
            psO[i] = psO[i-1] + (i%2 !=0 ? A[i] :0);
        }
        int lastIndex = A.length -1;
        int sumOdd = 0;
        int sumEven = 0;
        int count = 0;
        for(int i = 0 ; i <= lastIndex ;i++) {
            //when we remove index then odd index become even and even index become odd
            sumOdd =  (i == 0 ? 0 : psO[i-1]) + (i == lastIndex ? 0 :psE[lastIndex] - psE[i]);
            sumEven = ( i== 0? 0: psE[i-1]) + (i == lastIndex? 0: psO[lastIndex] -psO[i]);
            if(sumEven == sumOdd) {
                count++;
            }
        }
        return count;
    }
}
