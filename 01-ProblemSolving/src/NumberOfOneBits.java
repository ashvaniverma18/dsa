public class NumberOfOneBits {

    public static void main(String[] args) {
        int A = 11;
        int onesBit = 0;

        while(A > 0) {
            onesBit += A%2;
            A = A/2;
        }
        System.out.println(onesBit);
    }
}
