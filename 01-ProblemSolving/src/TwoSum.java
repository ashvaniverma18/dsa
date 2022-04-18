import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},18)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedElements = new HashMap<>();
        int otherNumber = 0;
        for(int i = 0; i< nums.length; i++) {
            otherNumber = target - nums[i];
            if(visitedElements.containsKey(otherNumber)) {
                return new int[]{visitedElements.get(otherNumber), i};
            }
            visitedElements.put(nums[i], i);
        }
        return null;
    }
}
