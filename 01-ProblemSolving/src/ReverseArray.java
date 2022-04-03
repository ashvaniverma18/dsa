import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseArray(new int[]{1,2,3,7,10})));
    }

    public static int[] reverseArray(int[] A) {
        int[] arr = new int[A.length];
        int start = 0;
        int end   = A.length -1;
        while(start <= end) {
            arr[start] = A[end];
            arr[end] = A[start];
            start++;
            end--;
        }
        return arr;
    }
}
