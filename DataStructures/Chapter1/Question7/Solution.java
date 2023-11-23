package Chapter1.Question7;

public class Solution {
    public static void setZero(int[][] matrix, int rowSize, int colSize) {
        int[] rowMap = new int[rowSize];
        int[] colMap = new int[colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    rowMap[i] = 1;
                    colMap[j] = 1;
                }
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (rowMap[i] == 1 || colMap[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }
}
