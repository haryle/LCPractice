import DataStructures.List;
import DataStructures.Queue;

public class QueueL<T> implements Queue<T> {
    private final List<T> buffer;

    public QueueL() {
        this.buffer = new LinkedList<>();
    }

    @Override
    public int size() {
        return buffer.size();
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public T enqueue(T elem) {
        return buffer.append(elem);
    }

    @Override
    public T dequeue() {
        T retVal = buffer.valueAt(0);
        buffer.deleteAt(0);
        return retVal;
    }
}
