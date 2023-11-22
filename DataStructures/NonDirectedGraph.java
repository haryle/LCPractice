import DataStructures.Edge;
import DataStructures.Vertex;

import java.util.List;
import java.util.Map;

public class NonDirectedGraph<T> extends DirectedGraph<T> {

    @Override
    public void addEdge(T src, T dst) {
        addNode(src);
        addNode(dst);
        Edge<T> edge = new NonDirectedEdge<>(src, dst, vertices);
        if (!edges.containsKey(List.of(src, dst)))
            edges.put(edge.getID(), edge);
    }

    protected static class NonDirectedEdge<T> extends Edge<T> {
        public NonDirectedEdge(T src, T dst, Map<T, Vertex<T>> vertices) {
            this.src = vertices.get(src) == null ? new Vertex<>(src) :
                    vertices.get(src);
            this.dst = vertices.get(dst) == null ? new Vertex<>(dst) :
                    vertices.get(dst);

            if (!this.src.neighbours.contains(this.dst))
                this.src.neighbours.add(this.dst);

            if (!this.dst.neighbours.contains(this.src))
                this.dst.neighbours.add(this.src);
        }
    }
}
