public class RotateForAGiveTime {

    public static void main(String[] args) {
        int[][] arrays = solve(new int[]{6, 31, 33, 13, 82, 66, 9, 12, 69, 21, 17, 2, 50, 69, 90, 71, 31, 1, 13, 70, 94, 46, 89, 13, 55, 54, 67, 97, 28, 27, 62, 34, 41, 18, 15, 35, 13, 84, 93, 27, 89, 23, 6, 56, 94, 40, 54, 95, 47 },
                new int[]{88, 85, 98, 36, 66, 40, 30, 26, 51, 77, 62, 60, 92, 64, 53, 86, 24, 53, 85, 49, 57, 29, 32, 60, 75, 82, 17, 23, 67, 51, 23, 11, 70, 59});


        for(int[] arr: arrays) {
            for(int n: arr) {
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }

    public static int[][] solve(int[] A, int[] B) {
        int[][] output = new int[B.length][];
        for (int i = 0; i < B.length; i++) {
            int[] array = A.clone();
            int numberOfRotate = B[i];
            if(numberOfRotate > array.length) {
                numberOfRotate = numberOfRotate % array.length;
            }
            reverseArray(array, 0, numberOfRotate - 1);
            reverseArray(array, numberOfRotate, array.length - 1);
            reverseArray(array, 0, array.length - 1);
            output[i] = array;
        }

        return output;
    }

    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            arr[start] = arr[start] + arr[end];
            arr[end] =  arr[start] - arr[end];
            arr[start] =  arr[start] - arr[end];

            start++;
            end--;
        }
    }
}
