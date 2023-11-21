import DataStructures.Queue;

import java.util.EmptyStackException;
import java.util.Vector;

public class VectorQueue<T> implements Queue<T> {
    private int tail;
    private final Vector<T> buffer;

    /**
     * Queue implementation using Java vector
     */
    public VectorQueue() {
        this.tail = 0;
        buffer = new Vector<>();
    }

    @Override
    public int size() {
        return tail;
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public T enqueue(T elem) {
        buffer.add(tail, elem);
        tail++;
        return elem;
    }

    @Override
    public T dequeue() {
        if (empty())
            throw new EmptyStackException();
        T retVal = buffer.get(0);
        buffer.remove(0);
        tail--;
        return retVal;
    }
}
