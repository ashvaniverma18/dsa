import java.util.ArrayList;
import java.util.List;

public class PairEqualToSum {
    public static void main(String[] args) {
        System.out.println(solve(List.of(1,4 ,5,7,8 ,9),15));
    }

    public static int solve(List<Integer> A, int B) {
       for(int i =0 ; i<A.size() ; i++) {
           for(int j = i+1; j< A.size(); j++) {
                if(A.get(i) + A.get(j) == B) {
                    return 1;
                }
           }
       }
       return 0;
    }
}
