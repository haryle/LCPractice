import DataStructures.Stack;

public class StackQ<T> implements Stack<T> {
    private final VectorQueue<T> mainQueue, reserveQueue;

    public StackQ() {
        mainQueue = new VectorQueue<>();
        reserveQueue = new VectorQueue<>();
    }

    @Override
    public boolean empty() {
        return mainQueue.empty();
    }

    @Override
    public int size() {
        return mainQueue.size();
    }

    @Override
    public T pop() {
        return mainQueue.dequeue();
    }

    @Override
    public T push(T elem) {
        while (!mainQueue.empty())
            reserveQueue.enqueue(mainQueue.dequeue());
        mainQueue.enqueue(elem);
        while (!reserveQueue.empty())
            mainQueue.enqueue(reserveQueue.dequeue());
        return elem;
    }
}
