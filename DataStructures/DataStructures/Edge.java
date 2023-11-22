package DataStructures;
import java.util.List;

public abstract class Edge<T> {
    protected Vertex<T> src;
    protected Vertex<T> dst;

    public List<T> getID(){
        return List.of(src.value, dst.value);
    }
    public String toString() {
        return "(" + src.toString() + ", " + dst.toString() + ")";
    }
}

