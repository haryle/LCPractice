import java.util.*;

public class LongestConsecutiveSequence {



    public static void main(String[] argv) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));
        nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(solution.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> table = new HashSet<>();
        for (int num: nums)
            table.add(num);

        int maxLength = 0;
        for (int num: table){
            if (!table.contains(num-1)){
                int length = 1;
                while (table.contains(num+length))
                    length++;
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }
}
