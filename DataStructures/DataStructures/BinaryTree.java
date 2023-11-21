package DataStructures;

import java.util.List;

public interface BinaryTree<T extends Comparable<T>> {
    public int size();

    public List<T> toList();

    public void print();

    public void add(T value);

    public void remove(T value);

    public boolean contains(T value);

}
