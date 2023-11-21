package DataStructures;

public interface Queue<T> {
    public int size();

    public boolean empty();

    public T enqueue(T elem);

    public T dequeue();
}
