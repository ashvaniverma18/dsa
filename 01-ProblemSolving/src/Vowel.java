public class Vowel {

    public static void main(String[] args) {

    }


    public static String solve(String A) {
        String substr = "";
        char ithChar = ' ';
        for(int i = 0 ; i < A.length(); i++) {
            ithChar = A.charAt(i);
            if(ithChar == 'a' || ithChar == 'e' || ithChar == 'i' || ithChar == 'o' || ithChar == 'u' ||
                    ithChar == 'A' || ithChar == 'E' || ithChar == 'I' || ithChar == 'O' || ithChar == 'U') {
                substr = substr + ithChar;
            }
        }
        return substr;
    }
}
