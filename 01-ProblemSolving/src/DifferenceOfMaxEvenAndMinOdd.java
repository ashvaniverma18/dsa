public class DifferenceOfMaxEvenAndMinOdd {
    public static void main(String[] args) {
        int[] A = {0, 2, 9};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < A.length ; i++) {
            if(A[i] == 0)
                continue;
            if(A[i] % 2 == 0 && A[i] > max) {
                max = A[i];
            }
            if(A[i] % 2 != 0 && A[i] <  min) {
                min = A[i];
            }
        }
        System.out.print(max - min);
    }
}
