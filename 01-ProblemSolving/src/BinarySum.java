public class BinarySum {

    public static void main(String[] args) {
        String A = "110011";
        String B = "101011";


        StringBuilder sum = new StringBuilder();

        int i = A.length() -1;
        int j = B.length() -1;

        int oneDigit = 0;
        int secondDigit =0 ;
        int carryForward = 0;
        while(i >= 0 || j >= 0) {
            oneDigit = i >= 0 ? A.charAt(i) == '0' ? 0 :1 : 0;
            secondDigit = j >= 0 ?  B.charAt(j) == '0' ? 0 :1 : 0;

            sum.append( (oneDigit+secondDigit+carryForward) % 2);
            carryForward = (oneDigit+secondDigit+carryForward) /2;
            i--;
            j--;
        }
        if(carryForward != 0) {
            sum.append(carryForward);
        }
        System.out.println(sum.reverse().toString());

    }
}
