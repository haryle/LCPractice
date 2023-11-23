package Chapter1.Question6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public int[][] generateTestMatrix(int size) {
        int[][] retVal = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                retVal[i][j] = i + j;
        }
        return retVal;
    }

    public void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void testRotate(int size) {
        int[][] mat = generateTestMatrix(size);
        int[][] retMat = mat.clone();
        for (int i = 0; i < 4; i++) {
            retMat = Solution.rotateImage(retMat, size);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                assertEquals(mat[i][j], retMat[i][j]);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void testRotateInPlace(int size) {
        int[][] mat = generateTestMatrix(size);
        int[][] retMat = mat.clone();
        for (int i = 0; i < 4; i++) {
            Solution.rotateInplace(retMat, size);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                assertEquals(mat[i][j], retMat[i][j]);
        }
    }
}