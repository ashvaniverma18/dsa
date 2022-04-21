package leetcode;

public class Leet852PeakIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0};
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                break;
            } else if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == arr.length - 1 || arr[mid] < arr[mid + 1])) {
                l = mid + 1;
            } else if ((mid == 0 || arr[mid - 1] > arr[mid]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                r = mid - 1;
            }
        }
        System.out.println(mid);
    }
}
