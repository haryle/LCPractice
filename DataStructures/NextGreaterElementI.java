import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public static void main(String[] argv) {
        NextGreaterElementI solution = new NextGreaterElementI();
        System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{4, 1, 2},
                new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{2, 4},
                new int[]{1, 2, 3, 4})));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> dictionary = new HashMap<>();
        for (int num: nums2){
            dictionary.put(num, -1);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > nums2[stack.peek()]) {
                int index = stack.pop();
                dictionary.put(nums2[index], nums2[i]);
            }
            stack.push(i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
            result[i] = dictionary.get(nums1[i]);
        return result;
    }
}
