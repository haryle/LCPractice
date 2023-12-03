import java.util.*;

public class ThreeSum {

    public static void main(String[] argv) {
        ThreeSum solution = new ThreeSum();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{0, 1, 1}));
        System.out.println(solution.threeSum(new int[]{0, 0, 0}));
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 0}));
        System.out.println(solution.threeSum(new int[]{3, 0, -2, -1, 1, 2}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        List<Integer> keySet = counter.keySet().stream().sorted().toList();
        for (int num : keySet) {
            if (num == 0) {
                if (counter.get(0) >= 3)
                    result.add(new ArrayList<>(List.of(0, 0, 0)));
            } else {
                if (counter.get(num) > 1) {
                    if (counter.getOrDefault(-2 * num, 0) > 1)
                        result.add(new ArrayList<>(List.of(num, num, -2 * num)).stream().sorted().toList());
                } else if ((num % 2) == 0 && counter.getOrDefault(-num / 2, 0) > 1)
                    result.add(new ArrayList<>(List.of(num, -num / 2, -num / 2)).stream().sorted().toList());
            }
        }

        for (int i = 0; i < keySet.size() - 1; i++) {
            int forward = i + 1;
            int backward = keySet.size() - 1;
            while (forward < backward) {
                int sum = keySet.get(forward) + keySet.get(i) + keySet.get(backward);
                if (sum == 0) {
                    result.add(new ArrayList<>(List.of(keySet.get(i),
                            keySet.get(forward), keySet.get(backward))).stream().sorted().toList());
                    forward++;
                    backward--;
                } else if (sum > 0) {
                    backward--;
                } else {
                    forward++;
                }
            }
        }
        return result.stream().toList();
    }
}
