public class DoubleLinkedList<T> extends LinkedList<T> {
    protected static class Node<T> extends  LinkedList.Node<T>{
        public T value;
        public Node<T> next, prev;

        public Node() {
            value = null;
            next = null;
            prev = null;
        }

        public Node(T value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }

    protected Node<T> sentinel, head, tail;

    public DoubleLinkedList() {
        sentinel = new Node<>();
        head = tail = sentinel;
        head.prev = sentinel;
        tail.next = sentinel;
    }

    @Override
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
    public T valueAt(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return nodeAt(index).value;
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
        next.prev = newNode;
        newNode.next = next;
        newNode.prev = prev;

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
        } else if (index == size - 1) {
            prev = tail.prev;
        } else
            prev = nodeAt(index - 1);
        if (index == size - 1)
            tail = prev;
        prev.next = prev.next.next;
        prev.next.prev = prev;
        size--;
    }
}
