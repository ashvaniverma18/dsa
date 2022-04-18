import java.util.ArrayList;
import java.util.List;

public class AlternatingSubarraysEasy {

    public static void main(String[] args) {
        solve(new int[]{0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0}, 2);

    }
    public static int[] solve(int[] A, int B) {
        if(B == 0) {
            int[] ar = new int[A.length];
            for(int i = 0; i<A.length ; i++) {
                ar[i] = i;
            }
            return ar;
        }
        List<Integer> index = new ArrayList<>();
        int s = 0;
        int e = 2 * B;
        int midIndex = (e-s+1)/2;
        while(s < A.length && e < A.length) {
            if(isAlternate(A, midIndex,  B))
                index.add(midIndex);
            midIndex++;
            s++;
            e++;
        }
        System.out.println(index);
        int[] arr = new int[index.size()];
        int ind = 0;
        for(Integer in : index) {
            arr[ind++] = in;
        }
        return arr;
    }

    private static boolean isAlternate(int[] arr, int midIndex, int B) {
        int expectedFromMid = 1- arr[midIndex];
        int stepFrom = 1;
        while(B > 0) {
            if(arr[midIndex - stepFrom]  == expectedFromMid && arr[midIndex + stepFrom] == expectedFromMid) {
                stepFrom++;
            }else {
                return false;
            }
            expectedFromMid = 1- expectedFromMid;
            B--;
        }
        return true;
    }
}
