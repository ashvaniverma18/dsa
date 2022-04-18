import java.util.Arrays;

public class MaximumPositvity {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{5, 6, -1, 7, 8})));
        //solve(new int[]{-1, -2, -3, -4, -5, -6});
    }

    public static int[] solve(int[] A) {
        int index = 0;
        int length = 0;
        int preStart = 0;
        int preLength = 0;
        int i = 0;
        while(i < A.length) {
            if(A[i] < 0) {
                preStart = i+1;
                preLength = 0;
            }else{
                preLength++;
            }
            if(preLength > length ) {
                length = preLength;
                index = preStart;
            }
            i++;
        }
        int[] array = new int[length];
        for(i = 0 ; i< length ;i++) {
            array[i] = A[i+index];
        }
        return array;
    }
/*
    public static int[] solve(int[] A) {
        int index = 0;
        int length = 0;
        for(int i = 0; i < A.length ;i++) {
            for(int j = i ; j < A.length ;j++) {
                if(A[j] < 0) {
                    break;
                }
                if( j-i+1 > length) {
                    length = j-i+1;
                    index = i;
                }
            }
        }
        int[] array = new int[length];
        for(int i = 0 ; i < length ; i++) {
            array[i] = A[index+i];
        }
        return array;

    }
*/
}
