public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] argv){
        LargestNumberAtLeastTwiceOfOthers solution = new LargestNumberAtLeastTwiceOfOthers();
        System.out.println(solution.dominantIndex(new int[]{3,6,1,0}));
    }

    public int dominantIndex(int[] nums) {
        int[] index = new int[50];
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;

        // Populate the LUT
        for (int i = 0; i < nums.length; i++){
            int key = nums[i];
            if (key > maxValue){
                maxValue = key;
                maxIndex = i;
            }
            index[key] = 1;
        }
        // Compare the result
        int id = maxValue - 1;
        while (id >= 0){
            if (index[id] != 0){
                if (maxValue >= 2*id)
                    return maxIndex;
                else
                    return -1;
            }
            id--;
        }
        return -1;
    }
}
