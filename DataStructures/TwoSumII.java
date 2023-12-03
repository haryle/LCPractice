import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] argv) {
        TwoSumII solution = new TwoSumII();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15},
                9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{-1, 0}, -1)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] result = new int[2];
        while (start < end) {
            int sum = numbers[end] + numbers[start];
            if (sum == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            } else if (sum > target)
                end--;
            else
                start++;
        }

        return result;
    }
}
