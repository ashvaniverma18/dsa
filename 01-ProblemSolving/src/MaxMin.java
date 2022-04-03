import java.util.Scanner;

public class MaxMin {

    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
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

        int max = arr[0];
        int min = arr[0];
        for(int i = 1 ; i < arr.length ; i++) {
            if(arr[i] %2 == 0 && arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] %2 != 0 && arr[i] <  min) {
                min = arr[i];
            }
        }
        System.out.print(max +" " + min);*/
        System.out.println(0%2);

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
