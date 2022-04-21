public class IntersetingArray {

    public static void main(String[] args) {
        int[] A ={9, 17};

        long totalSum = 0;
        for(int i =0 ; i< A.length ; i++) {
            totalSum += (long)A[i];
        }
        if( (totalSum | 1) != totalSum) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
