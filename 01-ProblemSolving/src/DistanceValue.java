import java.util.Arrays;

public class DistanceValue {

    public static void main(String[] args) {
        int[] arr1 = {1,4,2,3};
        int[] arr2 = {-4,-3,6,10,20,30};
        int d = 3;

        Arrays.sort(arr2);
        int count = 0;
        for(int i = 0; i< arr1.length ; i++) {
            if(!foundNumber(arr2, arr1[i]-d, arr1[i]+d))
                count++;
        }

    }

    private static boolean foundNumber(int[] arr, int s, int e) {
        int l = 0;
        int r = arr.length -1;
        int mid;
        while(l <= r) {
            mid = (l+r)/2;
            if(arr[mid] >= s && arr[mid] <= e)
                return true;

            if(arr[mid] > e)
                r = mid-1;
            else
                l = mid+1;
        }
        return false;
    }
}
