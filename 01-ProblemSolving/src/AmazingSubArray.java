/**
 * You are given a string S, and you have to find all the amazing substrings of S.
 *
 * An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 *
 * Input
 *
 * Only argument given is string S.
 * Output
 *
 * Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
 */
public class AmazingSubArray {

    public static void main(String[] args) {
        System.out.println(solve("ABEC"));
    }

    public static int solve(String A) {
        A = A.toLowerCase();
        long count = 0;
        char currentChar;
        int stringLength = A.length();
        for(int i = 0 ; i< stringLength ; i++) {
            currentChar = A.charAt(i);
            if(currentChar == 'a' ||
                    currentChar == 'e' ||
                    currentChar == 'i' || currentChar == 'o' ||
                    currentChar == 'u') {
                count = count + ( (stringLength -1) - i + 1 );
            }
        }
        return (int)(count % 10003);
    }
}
