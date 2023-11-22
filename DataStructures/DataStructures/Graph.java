package DataStructures;

import java.util.Map;
import java.util.List;

public interface Graph<T> {

    public void addNode(T value);

    public void addEdge(T src, T dst);

    public Map<T, Vertex<T>> getVertices();

    public Map<List<T>, Edge<T>> getEdges();

}
