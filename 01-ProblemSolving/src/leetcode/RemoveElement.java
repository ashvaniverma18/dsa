package leetcode;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;

        int left = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i]!=val){
                nums[left] = nums[i];
                left++;
            }
        }

        System.out.println(left);
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int a, int b) {
        if(b > a){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
