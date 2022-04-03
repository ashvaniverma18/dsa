import java.util.Scanner;

public class SearchElement {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfTestCase = scan.nextInt();

        while (numberOfTestCase > 0) {
            int input =  scan.nextInt();
            int[] arr =  new int[input];

            int index = 0;
            while(input > 0) {
                arr[index++] = scan.nextInt();
                input--;
            }

            int  numberToSearch = scan.nextInt();
            search(arr, numberToSearch);
            numberOfTestCase--;
        }
    }

    public static void search(int[] arr, int number) {
        int start = 0;
        int end   = arr.length-1;
        while(start <= end) {
            if(arr[start] == number || arr[end] == number) {
                System.out.println("1");
                return;
            }
            start++;
            end--;
        }
        System.out.println("0");
    }



}
