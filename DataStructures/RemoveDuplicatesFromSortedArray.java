import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        int N = nums.length;
        int prev = nums[0];
        int numUnique = 1;
        while (fast < N){
            if (nums[fast] != prev){
                nums[slow] = prev;
                slow++;
                prev = nums[fast];
                numUnique++;
            }
            fast++;
        }
        nums[slow] = prev;
        System.out.println(Arrays.toString(nums));
        return numUnique;
    }

    public static void main(String[] argv){
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2}));
    }
}
