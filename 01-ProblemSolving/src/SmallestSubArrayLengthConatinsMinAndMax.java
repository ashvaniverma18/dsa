public class SmallestSubArrayLengthConatinsMinAndMax {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{4, 4, 4, 4, 4}));
    }

    public static int solve(int[] A) {
        int[] minMax = minMax(A);
        int min = minMax[0];
        int max = minMax[1];
        int lastMinIndex = -1;
        int lastMaxIndex = -1;
        int smallestLength = 0;
        int calculatedLength;
        for(int i = 0 ; i< A.length; i++) {
            if(A[i] == min) {
                lastMinIndex = i;
            }
            if(A[i] == max){
                lastMaxIndex = i;
            }
            if(lastMaxIndex != -1 && lastMinIndex != -1) {
                calculatedLength = Math.abs(lastMaxIndex - lastMinIndex) +1;
                smallestLength = smallestLength == 0 ? calculatedLength:
                        Math.min(smallestLength, calculatedLength);
            }
        }

        return smallestLength;
    }

    public static int[] minMax(int[] A) {
        int min = A[0];
        int max = A[0];
        for(int i = 0 ; i < A.length ; i++) {
            if(A[i] > max) {
                max = A[i];
            }
            if(A[i] < min) {
                min = A[i];
            }
        }
        return new int[]{min, max};
    }
}
