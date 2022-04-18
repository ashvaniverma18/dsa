import java.util.*;

public class LeadersInArray {
    public static void main(String[] args) {
        System.out.println(solve(List.of(16, 17, 4, 3, 5, 2)));
    }

    public static ArrayList<Integer> solve(List<Integer> A) {
        ArrayList<Integer> leaders = new ArrayList();
        int lastMax = A.get(A.size()-1);
        leaders.add(lastMax);
        for(int i = A.size()- 2 ; i >= 0 ; i--) {
            if(A.get(i) > lastMax) {
                lastMax = A.get(i);
                leaders.add(lastMax);
            }
        }
        return leaders;
    }
}
