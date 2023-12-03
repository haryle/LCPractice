import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class ContainerMostWater {
    public static int findArea(int[] height, int start, int end){
        return Math.min(height[start], height[end]) * Math.abs(end-start);
    }

    public static void main(String[] argv) {
        ContainerMostWater solution = new ContainerMostWater();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 25, 7}));
        System.out.println(solution.maxArea(new int[]{1, 2, 3, 4}));
    }

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = 0;
        while (start < end){
            area = Math.max(area, Math.min(height[start], height[end]) * Math.abs(end-start));
            if (height[start] < height[end])
                start++;
            else
                end--;
        }
        return area;
    }
}
