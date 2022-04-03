import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 */
public class PlusOne {

    public static void main(String[] args) {
        Stack<Integer> newFinalNumber = new Stack();
        newFinalNumber.push(1);
        newFinalNumber.push(2);
        //Arrays.stream(newFinalNumber.toArray(new Integer[newFinalNumber.size()])).sequential().forEach( i -> System.out.println(i));
        //System.out.println(newFinalNumber.toArray(new Integer[newFinalNumber.size()]));
        //Arrays.stream().sequential().forEach( i -> System.out.println(i));
        plusOne(new int[]{1,2,3,9});
    }

    public static int[] plusOne(int[] digits) {
        if(digits[digits.length-1] != 9) {
            digits[digits.length-1] += 1;
            return digits;
        }
        Stack<Integer> newFinalNumber = new Stack();
        int carryForward = 0;
        for(int i = digits.length-1 ; i >= 0 ; i--) {
            int nextDigit = digits[i] + 1 + carryForward;
            if(nextDigit > 9) {
                newFinalNumber.push(0);
                carryForward = 1;
            }else {
                newFinalNumber.push(nextDigit);
                carryForward = 0;
            }
        }
        System.out.println(newFinalNumber);
        return digits;
    }
}
