import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums){
        if (nums.length == 1)
            return false;
        Map<Integer, Integer> counter = new HashMap<>();
        for (Integer num: nums){
            if (counter.containsKey(num))
                return true;
            counter.put(num, 1);
        }
        return false;
    }

    public static void main(String[] argv){
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }
}
