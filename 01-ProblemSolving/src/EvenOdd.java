import java.util.*;
import java.util.stream.Collectors;

public class EvenOdd {

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

            search(arr);
            numberOfTestCase--;
        }
    }

    public static void search(int[] arr) {
        Map<Integer, Integer> evenList = new TreeMap<>();
        Map<Integer, Integer> oddList = new TreeMap<>();

        int start = 0;
        int end   = arr.length-1;
        while(start <= end) {
            if(arr[start] % 2 == 0) {
                evenList.put(start, arr[start]);
            }else{
                oddList.put(start, arr[start]);
            }
            if(arr[end] % 2 == 0) {
                evenList.put(end, arr[end]);
            }else{
                oddList.put(end, arr[end]);
            }
            start++;
            end--;
        }
        System.out.println(printList(oddList.values()));
        System.out.println(printList(evenList.values()));

    }

    private static String printList(Collection<Integer> pritn) {
        String finalOut = pritn.stream().map( o -> String.valueOf(o)).collect(Collectors.joining(" "));
        if(!finalOut.equals("")) {
            finalOut = finalOut + " ";
        }
        return finalOut;
    }


}
