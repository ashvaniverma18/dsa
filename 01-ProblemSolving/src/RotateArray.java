import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] params = line.split("\\s");
        int[] arr = null;

        int index = 0;
        for(String param : params) {
            if(arr == null) {
                arr = new int[Integer.parseInt(param.trim())];
            }else{
                arr[index++] = Integer.parseInt(param.trim());
            }
        }

        long numberOfRotation = scan.nextLong();
        if(numberOfRotation > arr.length) numberOfRotation = numberOfRotation % arr.length;

        reverseArray(arr, 0, arr.length -1);
        reverseArray(arr, 0, (int)(numberOfRotation-1) );
        reverseArray(arr, (int)(numberOfRotation), arr.length -1);
        for(int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]);
            if( (i+1) != arr.length) {
                System.out.print(" ");
            }
        }
    }

    public static void reverseArray(int[] arr, int start, int end) {
         while(start < end) {
             arr[start] = arr[start] + arr[end];
             arr[end] = arr[start] - arr[end];
             arr[start] = arr[start] - arr[end];
             start++;
             end--;
         }
    }

}
