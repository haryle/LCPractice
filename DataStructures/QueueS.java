import DataStructures.Queue;
import DataStructures.Stack;

public class QueueS<T> implements Queue<T> {
    private final Stack<T> tailStack, headStack;

    /**
     * Queue implementation using two stacks
     */
    public QueueS() {
        tailStack = new VectorStack<>();
        headStack = new VectorStack<>();
    }


    @Override
    public int size() {
        return tailStack.size() + headStack.size();
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public T enqueue(T elem) {
        return tailStack.push(elem);
    }

    @Override
    public T dequeue() {
        if (headStack.empty()) {
            while (!tailStack.empty())
                headStack.push(tailStack.pop());
        }
        return headStack.pop();
    }
}
