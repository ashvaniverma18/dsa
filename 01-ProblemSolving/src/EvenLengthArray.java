import java.util.HashMap;
import java.util.Map;

public class EvenLengthArray {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{978, 847, 95, 729, 778, 586, 188, 782, 813, 870, 871, 940, 312, 693, 580, 101,
                760, 837, 564, 633, 680, 155, 241, 374, 682, 290, 850, 601, 433, 922, 773, 959, 530, 290, 990, 50, 516,
                409, 868, 131, 664, 851, 721, 880, 20, 450, 745, 387, 787, 823, 392, 242, 674, 347, 65, 135, 819, 324,
                651, 678, 139, 940}));
    }
    public static String solve(int[] A) {
        int lengthOfArray = A.length;
        if(lengthOfArray % 2 == 0 &&
                A[0] % 2 == 0 &&
                A[lengthOfArray-1] %2 ==0
        ){
            return "YES";
        }

        return "NO";
    }
   /* public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedElement = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {

        }
    }*/
}
