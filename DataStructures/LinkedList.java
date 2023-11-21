import DataStructures.List;


public class LinkedList<T> implements List<T> {

    protected static class Node<T> {
        public T value;
        public Node<T> next;

        public Node() {
            value = null;
            next = null;
        }

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }

    protected Node<T> head, tail;
    protected final Node<T> sentinel;

    protected int size;

    public LinkedList() {
        size = 0;
        sentinel = new Node<>();
        head = tail = sentinel;
        tail.next = sentinel;
    }

    protected Node<T> nodeAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            return head;
        if (index == size - 1)
            return tail;
        Node<T> ptr = head;
        for (int i = 0; i < index; i++)
            ptr = ptr.next;
        return ptr;
    }

    @Override
    public int size() {
        return size;
    }

    protected Node<T> searchNode(T key) {
        if (size == 0)
            return null;
        Node<T> ptr = head;
        for (int i = 0; i < size; i++) {
            if (ptr.value == key)
                return ptr;
            ptr = ptr.next;
        }
        return null;
    }

    @Override
    public int search(T key) {
        if (size == 0)
            return -1;
        Node<T> ptr = head;
        for (int i = 0; i < size; i++) {
            if (ptr.value == key)
                return i;
            ptr = ptr.next;
        }
        return -1;
    }

    @Override
    public T valueAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return nodeAt(index).value;
    }

    @Override
    public T prepend(T key) {
        return insert(key, 0);
    }

    @Override
    public T append(T key) {
        return insert(key, size);
    }

    @Override
    public T insert(T value, int index) {
        Node<T> prev, next;
        Node<T> newNode = new Node<>(value);
        if (index == 0)
            prev = sentinel;
        else if (index == size)
            prev = tail;
        else
            prev = nodeAt(index - 1);
        next = prev.next;
        prev.next = newNode;
        newNode.next = next;
        if (index == 0)
            head = newNode;
        if (index == size)
            tail = newNode;
        size += 1;
        return value;
    }

    @Override
    public void delete(T key) {
        int index = search(key);
        if (index != -1)
            deleteAt(index);
    }

    @Override
    public void deleteAt(int index) {
        Node<T> prev;
        if (index == 0) {
            prev = sentinel;
            head = head.next;
        }
        else
            prev = nodeAt(index - 1);

        if (index == size - 1){
            tail = prev;
        }
        prev.next = prev.next.next;
        size--;
    }

}

