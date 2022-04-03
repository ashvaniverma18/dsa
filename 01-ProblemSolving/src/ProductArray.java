import java.util.Arrays;

public class ProductArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{1, 2, 3, 4, 5})));
    }
    public static int[] solve(int[] A) {
        int[] productArray = new int[A.length];
        long allProduct = 1;
        for(int i = 0; i < A.length ;i++) {
            allProduct *= A[i];
        }
        for(int i = 0; i < A.length ;i++) {
            productArray[i] = (int)(allProduct/A[i]);
        }
        return productArray;
    }
}
