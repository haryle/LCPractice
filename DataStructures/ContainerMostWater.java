import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class ContainerMostWater {
    public static int findArea(int[] height, int lo, int hi) {
        return Math.min(height[lo], height[hi]) * Math.abs(hi - lo);
    }

    public static void main(String[] argv) {
        ContainerMostWater solution = new ContainerMostWater();
//        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 25, 7}));
    }

    public int maxArea(int[] height) {
        int[] sortedIndices = IntStream.range(0, height.length)
                .boxed().sorted(Comparator.comparing(i -> height[i]))
                .mapToInt(i -> i).toArray();
        int N = height.length;
        int minIdx = Math.min(sortedIndices[N - 1], sortedIndices[N - 2]);
        int maxIdx = Math.max(sortedIndices[N - 1], sortedIndices[N - 2]);
        int retVal = findArea(height, minIdx, maxIdx);
        int ptr = N - 2;
        System.out.println(Arrays.toString(sortedIndices));
        while (ptr > 0) {
            ptr -= 1;
            int leftArea = findArea(height, minIdx, sortedIndices[ptr]);
            int rightArea = findArea(height, maxIdx, sortedIndices[ptr]);
            retVal = Math.max(Math.max(leftArea, rightArea), retVal);
            minIdx = Math.min(minIdx, sortedIndices[ptr]);
            maxIdx = Math.max(maxIdx, sortedIndices[ptr]);
        }
        return retVal;
    }
}
