public class SubString {

    public static void main(String[] args) {
        System.out.println(solve("10110100110010011100"));
    }


    public static int solve(String str) {
        int count0 = 0;
        int count1 = 0;
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
            if (count0 == count1) {
                total++;
            }
        }
        return total;
    }

    public static int countChar(char[] array, int index, char c, int maxNumber) {
        int count = 0;
        while (index < array.length) {
            if (maxNumber != -1 && count == maxNumber) {
                break;
            }
            if (array[index++] == c) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
