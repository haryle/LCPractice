import DataStructures.Graph;
import DataStructures.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {
    public static <T> void Visit(Graph<T> graph){
        Map<T, Boolean> visited = new HashMap<>();
        Map<T, Vertex<T>> parent = new HashMap<>();
        List<T> discovered = new ArrayList<>();
        for (Vertex<T> node: graph.getVertices().values()){
            visited.put(node.value, false);
            parent.put(node.value, null);
        }

        for (Vertex<T> node: graph.getVertices().values()){
            if (!visited.get(node.value))
                DFS_Visit(node, visited, parent, discovered);
        }
        for (T value: discovered){
            System.out.println(value +", " + parent.get(value));
        }
    }

    private static <T> void DFS_Visit(Vertex<T> node, Map<T, Boolean> visited, Map<T, Vertex<T>> parent, List<T> discovered){
        visited.put(node.value, true);
        for (Vertex<T> child: node.neighbours){
            if (!visited.get(child.value)){
                parent.put(child.value, node);
                visited.put(child.value, true);
                DFS_Visit(child, visited, parent, discovered);
                if (!discovered.contains(child.value))
                    discovered.add(child.value);
            }
        }
        if (!discovered.contains(node.value))
            discovered.add(node.value);
    }
}
