public class SpecialSubSequenceAG {


    public static void main(String[] args) {
        System.out.println(solve("GAB"));
    }

    public static int solve(String A) {
        long numberOfACount = 0;
        long sequenceCount  = 0;
        for(int i = 0 ;  i < A.length() ;i++) {
            //update coun when A occurs
            if(A.charAt(i) == 'A') {
                numberOfACount++;
            }else if(A.charAt(i) == 'G') {
                //when G occurs all the A on left side of this G will make pair so update sequence count
                sequenceCount += numberOfACount;
            }
        }
        return (int)(sequenceCount % (Math.pow(10,9)+7));
    }
}
