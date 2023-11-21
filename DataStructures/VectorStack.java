import DataStructures.Stack;

import java.util.EmptyStackException;
import java.util.Vector;

public class VectorStack<T> implements Stack<T> {
    private int top;
    private final int capacity;

    private final Vector<T> buffer;

    /**
     * Stack implementation using unbounded vector
     */
    public VectorStack() {
        top = 0;
        this.capacity = -1;
        this.buffer = new Vector<>();
    }

    /**
     * Stack implementation using bounded vector
     *
     * @param capacity vector capacity
     */
    public VectorStack(int capacity) {
        top = 0;
        this.capacity = capacity;
        this.buffer = new Vector<>(capacity);
    }

    @Override
    public boolean empty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    private T peek() {
        if (empty())
            throw new EmptyStackException();
        return buffer.get(top - 1);
    }

    @Override
    public T pop() {
        T retVal = peek();
        top--;
        return retVal;
    }

    @Override
    public T push(T elem) {
        if (capacity != -1 && size() == capacity)
            throw new IndexOutOfBoundsException();
        buffer.add(top, elem);
        top++;
        return elem;
    }
}
