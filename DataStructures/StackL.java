import DataStructures.List;
import DataStructures.Stack;

public class StackL<T> implements Stack<T> {
    private final List<T> buffer;

    public StackL(){
        buffer = new LinkedList<>();
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return buffer.size();
    }

    @Override
    public T pop() {
        T retVal = buffer.valueAt(size()-1);
        buffer.deleteAt(size()-1);
        return retVal;
    }

    @Override
    public T push(T elem) {
        return buffer.append(elem);
    }
}
