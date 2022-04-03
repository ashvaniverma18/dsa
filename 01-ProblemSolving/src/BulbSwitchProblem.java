/**
 * N light bulbs are connected by a wire.
 *
 * Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
 *
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 *
 * You can press the same switch multiple times.
 *
 * Note: 0 represents the bulb is off and 1 represents the bulb is on.
 * Input 1:
 *
 *  A = [0, 1, 0, 1]
 * Input 2:
 *
 *  A = [1, 1, 1, 1]
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  4
 * Output 2:
 *
 *  0
 */
public class BulbSwitchProblem {
    public static void main(String[] args) {
        System.out.println(bulbs(new int[]{1, 1, 1, 1}));
    }

    public static int bulbs(int[] A) {
        int count = 0;
        int currentBulbState;
        for(int i = 0 ; i< A.length ;i++) {
            currentBulbState = A[i];
            if(count % 2 != 0){
                currentBulbState = 1 - currentBulbState;
            }
            if(currentBulbState == 0) {
                count++;
            }
        }
        return count;
    }
}
