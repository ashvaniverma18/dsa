public class StarPattern {

    public static void main(String[] args) {
        int a = 2;
        for(int i = 0; i< a ;i++) {
            printRow(i,a);
            System.out.println("");
        }

        for(int i = a-1; i>=0  ;i--) {
            printRow(i,a);
            System.out.println("");
        }
    }

    private static void printRow(int i, int a) {
        for(int j = 0 ; j < 2*a ; j++) {
            if( i != 0 && j >= a-i && j < a+i) {
                System.out.print("  ");
            }else {
                System.out.print(" *");

            }
        }
    }
}
