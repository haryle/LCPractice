import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {

    public static void main(String[] argv) {
        TimeNeededToInformAllEmployees solution = new TimeNeededToInformAllEmployees();
        System.out.println(solution.numOfMinutes(5, 0, new int[]{-1, 0, 0, 1, 2},
                new int[]{2, 1, 1, 3, 4}));
        System.out.println(solution.numOfMinutes(15, 0, new int[]{-1, 0, 0, 1, 1, 2,
                2, 3, 3, 4, 4, 5, 5, 6, 6}, new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0
                , 0, 0, 0, 0}));
        System.out.println(Character.getNumericValue('1'));
    }

    public void DFSVisit(int id, Map<Integer, List<Integer>> dictionary,
                         int[] informTime, int currentTime, int[] totalTime) {

        if (!dictionary.containsKey(id))
            totalTime[0] = Math.max(currentTime, totalTime[0]);
        else{
            currentTime += informTime[id];
            for (int subId: dictionary.get(id))
                DFSVisit(subId, dictionary, informTime, currentTime, totalTime);
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> dictionary = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (dictionary.containsKey(manager[i]))
                dictionary.get(manager[i]).add(i);
            else
                dictionary.put(manager[i], new ArrayList<>(List.of(i)));
        }
        int[] totalTime = new int[]{0};
        DFSVisit(headID, dictionary, informTime, 0, totalTime);
        return totalTime[0];
    }
}
