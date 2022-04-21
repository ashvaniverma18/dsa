package leetcode;

public class Leet35_SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int val = 7;

       /* int low = 0;
        int high = nums.length;
        int mid = 0;
        while (low < high){
            mid = (low+high)/2;
            if(nums[mid] == val) {
                break;
            }else if (nums[mid] < val)
                low = mid+1;
            else
                high = mid;
        }
        System.out.println(low);*/

        int l = 0;
        int r = nums.length;
        int mid = 0;
        while(l < r) {
            mid = (l +r)/2;
            if(nums[mid] == val) {
                l  = mid;
                break;
            }else if( val < nums[mid]) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        System.out.println(l);
        //System.out.println(mid);
    }

}
