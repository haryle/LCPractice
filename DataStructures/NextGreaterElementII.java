import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] argv) {
        NextGreaterElementII solution = new NextGreaterElementII();
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{5, 6, 7, 3, 2})));
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100})));
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < nums.length; i++) {
                while (!stack.empty() &&  nums[i] > nums[stack.peek()])
                    result[stack.pop()] = nums[i];
                stack.push(i);
            }
        }
        return result;
    }
}
