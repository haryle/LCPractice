import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k){
            return nums;
        }
        Map<Integer, Integer> counter = new HashMap<>();
        for (int key: nums)
            counter.put(key, counter.getOrDefault(key, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                }
        );

        pq.addAll(counter.entrySet());
        int[] retVal = new int[k];
        for (int i = 0; i < k; i++){
            Map.Entry<Integer, Integer> entry =  pq.poll();
            assert entry != null;
            retVal[i] = entry.getKey();
        }

        return retVal;
    }

    public static void main(String[] argv){
        TopKFrequent solution = new TopKFrequent();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
