import java.util.*;

public class TwoSum {
    public int[] twoSum(int [] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int val = nums[i];
            if (map.containsKey(val)){
                if (val * 2 == target){
                    return new int[]{map.get(val), i};
                }
            }
            else
                map.put(val, i);
        }

        for (int key: map.keySet()){
            int complement = target - key;
            if (map.containsKey(complement))
                return new int[]{map.get(key), map.get(complement)};
        }
        return new int[]{0, 0};
    }

    public static void main(String[] argv){
        TwoSum solution = new TwoSum();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{1, 2, 3}, 4)));
    }
}
