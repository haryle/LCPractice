public class BestSightseeingPair {
    public static void main(String[] argv){
        BestSightseeingPair solution = new BestSightseeingPair();
        System.out.println(solution.maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
        System.out.println(solution.maxScoreSightseeingPair(new int[]{1,2}));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int bestScore = Integer.MIN_VALUE;
        int bestIndex = 0;
        int N = values.length;
        for (int i = 1; i < N; i++){
            bestScore = Math.max(values[bestIndex] + bestIndex + values[i]-i, bestScore);
            if (values[bestIndex] + bestIndex < values[i] + i)
                bestIndex = i;
        }
        return bestScore;
    }
}
