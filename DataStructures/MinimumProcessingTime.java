import java.util.Collections;
import java.util.List;

public class MinimumProcessingTime {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        tasks.sort(Collections.reverseOrder());
        int N = processorTime.size();
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++)
            maxTime = Math.max(maxTime, processorTime.get(i)+tasks.get(4*i));
        return maxTime;
    }
}
