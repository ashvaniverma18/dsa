import java.util.Arrays;
import java.util.Scanner;

public class SecondLargest {

    public static void main(String[] args) {
        System.out.println(secondLarge(new int[]{1,2,3}));
    }

    public static int secondLarge(int[] A) {
        if(A.length <= 1) {
            return -1;
        }
        for(int i = 0 ; i < A.length ; i++) {
            for(int j = i+1; j < A.length ;j++) {
                if (A[i] > A[j])
                {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        return (A[A.length -2]);
    }
}
