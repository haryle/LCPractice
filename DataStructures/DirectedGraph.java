import DataStructures.Edge;
import DataStructures.Graph;
import DataStructures.Vertex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraph<T> implements Graph<T> {
    protected final Map<T, Vertex<T>> vertices;
    protected final Map<List<T>, Edge<T>> edges;


    public DirectedGraph() {
        vertices = new HashMap<>();
        edges = new HashMap<>();
    }

    @Override
    public void addNode(T value) {
        if (!vertices.containsKey(value))
            vertices.put(value, new Vertex<>(value));
    }

    @Override
    public void addEdge(T src, T dst) {
        addNode(src);
        addNode(dst);
        Edge<T> edge = new DirectedEdge<>(src, dst, vertices);
        if (!edges.containsKey(List.of(src, dst)))
            edges.put(edge.getID(), edge);
    }

    @Override
    public Map<T, Vertex<T>> getVertices() {
        return vertices;
    }

    @Override
    public Map<List<T>, Edge<T>> getEdges() {
        return edges;
    }

    protected static class DirectedEdge<T> extends Edge<T> {
        public DirectedEdge(T src, T dst, Map<T, Vertex<T>> vertices) {
            this.src = vertices.get(src) == null ? new Vertex<>(src) : vertices.get(src);
            this.dst = vertices.get(dst) == null ? new Vertex<>(dst) : vertices.get(dst);
            if (!this.src.neighbours.contains(this.dst))
                this.src.neighbours.add(this.dst);
        }
    }

}
