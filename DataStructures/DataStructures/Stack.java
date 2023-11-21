package DataStructures;

public interface Stack<T> {
    public boolean empty();

    public int size();
    
    public T pop();

    public T push(T elem);

}
