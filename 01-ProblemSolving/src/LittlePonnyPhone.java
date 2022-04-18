import java.util.Arrays;

public class LittlePonnyPhone {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{2, 4, 4, 6},
                new int[]{20, 4, 12, 1})));
    }

   /* public static int[] solve(int[] A, int[] B) {
        int[] result = new int[B.length];

        for(int i = 0 ; i < B.length ;i++) {
            int price = B[i];
            for(int j = 0; j< A.length ; j++) {
                if(price >= A[j]) {
                    result[i] += 1;
                    price = price - A[j];
                }else {
                    break;
                }
            }
        }

        return result;
    }*/


    public static int[] solve(int[] A, int[] B) {
        int[] result = new int[B.length];
        long[] ps = new long[A.length];
        ps[0] = A[0];
        for(int i = 1; i<A.length ;i++) {
            ps[i] = ps[i-1] + (long)A[i];
        }

        for(int i = 0 ; i < B.length ;i++) {
            if(B[i] < A[0]) {
                result[i] = 0;
            }else{
                result[i] =binarySearch(ps, B[i]);
            }
        }

        return result;
    }

    private static int binarySearch(long[] ps, int number) {
        int l = 0;
        int r = ps.length-1;
        int mid =0;
        int lastMid = 0;

        while(l <= r) {
            mid = (l+r)/2;
            if(number == ps[mid]) {
                break;
            }else if(number > ps[mid]) {
                if(mid+1 != ps.length && number < ps[mid+1]) {
                    break;
                }
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return mid+1;
    }
}
