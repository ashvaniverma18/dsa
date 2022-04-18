package twodarray;

public class SprialPrinting {

    public static void main(String[] args) {
        print(generateMatrix(5));
    }

    public static int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];
        int top = 0, left = 0;
        int bottom = A-1, right = A-1;
        int di = 0;
        int num = 1;
        while(top <= bottom && left <= right){
            if(di == 0) {
                for(int i = left ; i <= right ; i++) {
                    result[top][i] = num++;
                }
                top++;
            }else if(di == 1) {
                for(int i = top; i <=bottom ;i++) {
                    result[i][right] = num++;
                }
                right--;
            }else if(di == 2) {
                for(int i = right ; i >= left ;i--) {
                    result[bottom][i] = num++;
                }
                bottom--;
            }else if(di == 3) {
                for(int i = bottom ; i >= top ; i--) {
                    result[i][left] = num++;
                }
                left++;
            }
            di = (di+1)%4;
        }

        return  result;

    }

    public static void print(int[][] matrx) {
        for (int r = 0; r < matrx.length; r++) {       //for loop for row iteration.
            for (int c = 0; c < matrx[r].length; c++) {   //for loop for column iteration.
                System.out.print(matrx[r][c] + " ");
            }
            System.out.println("");
        }

    }
}
