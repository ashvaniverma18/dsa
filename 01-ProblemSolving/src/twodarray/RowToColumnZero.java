package twodarray;

import java.util.HashSet;
import java.util.Set;

public class RowToColumnZero {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},
                       {5,6,7,0},
                       {9,2,0,4}};

        print(solve(arr));
    }

    public static void print(int[][] matrx) {
        for (int r = 0; r < matrx.length; r++) {       //for loop for row iteration.
            for (int c = 0; c < matrx[r].length; c++) {   //for loop for column iteration.
                System.out.print(matrx[r][c] + " ");
            }
            System.out.println("");
        }

    }

/*
    public static int[][] solve(int[][] A) {
        int[][] result = new int[A.length][A[0].length];

        Set<Integer> alreadyZeroColumn = new HashSet<>();
        boolean rowFilled;
        for(int i = 0 ; i < A.length ;i++) {
            rowFilled = false;
            for(int j = 0; j < A[0].length ; j++) {
                if(alreadyZeroColumn.contains(j)) {
                    continue;
                }
                if(!alreadyZeroColumn.contains(j) && A[i][j] == 0) {
                    if(!rowFilled) {
                        fillRow(result, i,j);
                    }
                    fillZero(result, i, j);
                    rowFilled = true;
                    alreadyZeroColumn.add(j);
                }
                if(!rowFilled)
                    result[i][j] = A[i][j];

            }
        }
        return result;
    }
*/

    public static int[][] solve(int[][] A) {
        int[][] result = new int[A.length][A[0].length];

        Set<Integer> zeroValueColumns = new HashSet<>();
        Set<Integer> zeroValueRows = new HashSet<>();

        for(int i = 0 ; i < A.length ;i++) {
            for(int j = 0; j < A[0].length ; j++) {
                if(A[i][j] == 0) {
                    zeroValueRows.add(i);
                    zeroValueColumns.add(j);
                }else if(!zeroValueColumns.contains(j)) {
                    result[i][j] = A[i][j];
                }
            }
        }
        int i = 0;
        while(i < A.length) {
            if(zeroValueRows.contains(i)) {
                fillRow(result, i);
            }
            for(Integer col: zeroValueColumns) {
                result[i][col] = 0;
            }
            i++;
        }
        return result;
    }

    public static void fillRow(int[][] A, int row) {
        for(int j = 0; j < A[0].length ; j++) {
            A[row][j] = 0;
        }
    }

}
