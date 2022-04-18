package twodarray;

public class MatrixRotate {

    public static void main(String[] args) {
        int[][] ar = new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        solve(ar);
        print(ar);
    }

    public static void print(int[][] matrx) {
        for (int r = 0; r < matrx.length; r++) {       //for loop for row iteration.
            for (int c = 0; c < matrx[r].length; c++) {   //for loop for column iteration.
                System.out.print(matrx[r][c] + " ");
            }
            System.out.println("");
        }

    }

    public static void solve(int[][] A) {
        for(int i = 0 ; i < A.length ;i++) {
            for(int j = i+1; j < A.length ;j++) {
                A[i][j]  = A[i][j] + A[j][i];
                A[j][i]  = A[i][j] - A[j][i];
                A[i][j]  = A[i][j] - A[j][i];
            }
        }
        for(int i = 0 ; i < A.length ;i++) {
            reverseArray(A[i]);
        }
    }

    public static void reverseArray(int[] arr) {
        int s = 0;
        int e = arr.length-1;
        while(s < e) {
            arr[s] = arr[s] + arr[e];
            arr[e] = arr[s] - arr[e];
            arr[s] = arr[s] - arr[e];
            s++;
            e--;
        }
    }
}
