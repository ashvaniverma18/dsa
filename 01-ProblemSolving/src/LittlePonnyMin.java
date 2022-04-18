public class LittlePonnyMin {
    public static void main(String[] args) {

    }
    public int solve(int[] A, int B) {
        boolean foundB = false;
        int count = 0;
        for(int i = 0; i < A.length ;i++) {
            if(A[i] == B) {
                foundB = true;
            }
            if(A[i] >  B) {
                count++;
            }
        }
        return foundB && count !=0 ? count: -1;
    }
}
