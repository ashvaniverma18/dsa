package leetcode;

public class MaxWaterInContainer {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int maxSum = 0;
        int left = 0;
        int right = height.length -1;
        int sum ;
        while(left < right) {
            sum = Math.min(height[left], height[right]) * (right -left);
            if(height[left] < height[right]) {
                left++;
            }else{
                right--;
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
