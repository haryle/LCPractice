package Chapter1.Question6;

public class Solution {
    public static int[][] rotateImage(int[][] image, int size) {
        int[][] retVal = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                retVal[i][j] = image[size - 1 - i][j];
        }
        return retVal;
    }

    public static void rotateInplace(int[][] image, int size) {
        int[] temp = new int[4];
        for (int k = 0; k < size / 2; k++) {
            for (int j = k; j < size - k - 1 ; j++) {
                // Store temps
                temp[0] = image[k][j];
                temp[1] = image[size - 1 - j][k];
                temp[2] = image[size - 1 - k][size - 1 - j];
                temp[3] = image[j][size - 1 - k];

                // Swap values
                image[size - 1 - j][k] = temp[0];
                image[size - 1 - k][size - 1 - j] = temp[1];
                image[j][size - 1 - k] = temp[2];
                image[k][j] = temp[3];
            }
        }
    }
}
