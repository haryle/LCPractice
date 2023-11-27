package DataStructures;

public interface PriorityQueue<T> {
    public void insert(T value);

    public T peek();

    public T extract();

    public void set(int index, T value);
}
