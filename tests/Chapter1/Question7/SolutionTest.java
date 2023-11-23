package Chapter1.Question7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public void generateTestMatrix(int[][] inputMatrix, int[][] outputMatrix,
                                   int M, int N, int[] locRow, int[] locCol,
                                   int size) {

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                inputMatrix[i][j] = i + j + 1;
                outputMatrix[i][j] = i + j + 1;
            }
        }

        for (int i = 0; i < size; i++) {
            inputMatrix[locRow[i]][locCol[i]] = 0;
            for (int j = 0; j < N; j++)
                outputMatrix[locRow[i]][j] = 0;
            for (int k = 0; k < M; k++)
                outputMatrix[k][locCol[i]] = 0;
        }
    }

    public void compareMatrices(int[][] expected, int[][] actual, int M, int N) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                assertEquals(expected[i][j], actual[i][j]);
        }
    }

    @ParameterizedTest
    @CsvSource(
            value = {"3,4,0:1,0:1",
                    "2,2,0,1",
                    "3,3,2,2"
            }, delimiter = ','
    )
    void testSetZero(String M, String N, String locRow, String locCol) {
        int rowSize = Integer.parseInt(M);
        int colSize = Integer.parseInt(N);
        String[] locRows = locRow.split(":");
        String[] locCols = locCol.split(":");
        int size = locRows.length;
        int [] rowIndex = new int[size];
        int [] colIndex = new int[size];
        for (int i = 0; i < size; i++){
            rowIndex[i] = Integer.parseInt(locRows[i]);
            colIndex[i] = Integer.parseInt(locCols[i]);
        }
        int[][] inputMat = new int[rowSize][colSize];
        int[][] expectedMat = new int[rowSize][colSize];
        generateTestMatrix(inputMat, expectedMat, rowSize, colSize, rowIndex, colIndex, size);
        Solution.setZero(inputMat, rowSize, colSize);
        compareMatrices(expectedMat, inputMat, rowSize, colSize);
    }
}