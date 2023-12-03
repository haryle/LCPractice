import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NodeWithHighestEdgeScore {
    public int edgeScore(int[] edges) {
        Map<Integer, Long> counter = new HashMap<>();
        for (int i = 0; i < edges.length; i++){
            counter.put(edges[i], counter.getOrDefault(edges[i], 0l) + i);
        }
        long maxScore = -1;
        int bestIdx = -1;
        for (int key: counter.keySet()){
            long value = counter.get(key);
            if ((value > maxScore) || (value == maxScore && key < bestIdx)) {
                maxScore = value;
                bestIdx = key;
            }
        }
        return bestIdx;
    }

    public static void main(String[] argv){
        NodeWithHighestEdgeScore solution = new NodeWithHighestEdgeScore();
        System.out.println(solution.edgeScore(new int[]{1, 0, 0, 0, 0, 7, 7, 5}));
        System.out.println(solution.edgeScore(new int[]{2, 0, 0, 2}));
        System.out.println(solution.edgeScore(new int[]{1,0,1,1,1,1,1,1,1,1}));

    }
}
