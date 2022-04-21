package leetcode;

public class Leet34 {

    public static void main(String[] args) {
        int n = 10;
        int l = 1;
        int r = n;
        int mid =0;
        int guessResult;
        while(l <= r) {
            mid = l + (r-l)/2;
            guessResult = guess(mid);
            if(guessResult == -1) {
                r = mid-1;
            }else if(guessResult == 1) {
                l = mid+1;
            }else {
                break;
            }

        }
        System.out.println(mid);

    }

    public static  int guess(int num) {
        return num > 6 ? -1 : num < 6 ? 1: 0;
    }
}
