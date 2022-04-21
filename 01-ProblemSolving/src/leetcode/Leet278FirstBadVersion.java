package leetcode;

public class Leet278FirstBadVersion {

    public static void main(String[] args) {
        int n = 2126753390;

        int l = 1;
        int h = n;
        int mid;
        int totalItr = 0;
        while(l < h) {
            mid =  l +  (h -l)/2;
            totalItr++;
            if(isBadVersion(mid)) {
                h = mid-1;
            }else{
                l = mid+1;
            }

        }
        System.out.println(totalItr);
        System.out.println(h);
    }


    public static boolean isBadVersion(int n) {
        return n >= 1702766719;
    }
}
