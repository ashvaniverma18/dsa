public class PerfectSqaureOrNot {
    public static void main(String[] args) {
        int num = 2147483647;

        long l = 1;
        long r = num;
        long square;
        while(l <= r){
            square = l + (r-l)/2;
            if(square * square == num) {
                System.out.println(true);
            }
            if(square * square > num)
                r = square -1;
            else
                l = square +1;
        }
        System.out.println(false);
    }
}
