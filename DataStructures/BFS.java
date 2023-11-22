import DataStructures.Graph;
import DataStructures.Vertex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFS {
    public static <T> void Visit(Graph<T> graph, T value) {
        Vertex<T> node = graph.getVertices().get(value);
        if (node != null)
            Visit(graph, node);
    }

    public static <T> void Visit(Graph<T> graph, Vertex<T> node) {
        if (!graph.getVertices().containsKey(node.value))
            return;
        Map<T, Boolean> visited = new HashMap<>();
        Map<T, Vertex<T>> parent = new HashMap<>();
        Map<T, Integer> distance = new HashMap<>();

        Queue<Vertex<T>> queue = new LinkedList<>();
        for (Vertex<T> vertex : graph.getVertices().values()) {
            visited.put(vertex.value, false);
            parent.put(vertex.value, null);
            distance.put(vertex.value, 0);
        }
        queue.add(node);
        while (!queue.isEmpty()) {
            Vertex<T> vertex = queue.poll();
            for (Vertex<T> neighbour : vertex.neighbours) {
                if (!visited.get(neighbour.value)) {
                    visited.put(neighbour.value, true);
                    distance.put(neighbour.value, distance.get(vertex.value) + 1);
                    parent.put(neighbour.value, vertex);
                    queue.add(neighbour);
                }
            }
            System.out.println(vertex + ", " + parent.get(vertex.value) + ", " + distance.get(vertex.value));
        }
    }

}
