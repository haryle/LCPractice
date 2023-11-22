package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    public T value;

    public List<Vertex<T>> neighbours;

    public Vertex(T value) {
        this.value = value;
        neighbours = new ArrayList<>();
    }

    public String toString() {
        return value.toString();
    }
}
