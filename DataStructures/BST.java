import DataStructures.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BST<T extends Comparable<T>> implements BinaryTree<T> {
    protected Node<T> root;
    protected int size;

    public BST() {
        size = 0;
        root = null;
    }

    @Override
    public int size() {
        return size;
    }

    protected void walk(Node<T> node, List<T> array) {
        if (node != null) {
            walk(node.left, array);
            array.add(node.value);
            walk(node.right, array);
        }
    }

    @Override
    public void print() {
        List<T> array = new ArrayList<>();
        walk(root, array);
        System.out.println(array);
    }

    public List<T> toList() {
        List<T> array = new ArrayList<>();
        walk(root, array);
        return array;
    }

    @Override
    public void add(T value) {
        Node<T> parentPtr = null;
        Node<T> ptr = root;
        Node<T> node = new Node<>(value);
        while (ptr != null) {
            parentPtr = ptr;
            if (value.compareTo(ptr.value) < 0)
                ptr = ptr.left;
            else
                ptr = ptr.right;
        }
        node.parent = parentPtr;
        if (parentPtr == null)
            root = node;
        else if (value.compareTo(parentPtr.value) < 0)
            parentPtr.left = node;
        else
            parentPtr.right = node;
        size++;
    }

    protected Node<T> findMin(Node<T> src) {
        while (src.left != null)
            src = src.left;
        return src;
    }

    protected void transplant(Node<T> src, Node<T> dst) {
        if (src.parent == null)
            root = dst;
        else if (src == src.parent.left)
            src.parent.left = dst;
        else
            src.parent.right = dst;
        if (dst != null)
            dst.parent = src.parent;
    }


    @Override
    public void remove(T value) {
        size--;
        Node<T> node = search(value, root);
        if (node.left == null)
            transplant(node, node.right);
        else if (node.right == null)
            transplant(node, node.left);
        else {
            Node<T> successor = findMin(node.right);
            if (successor.parent != node) {
                transplant(successor, successor.right);
                successor.right = node.right;
                successor.right.parent = successor;
            }
            transplant(node, successor);
            successor.left = node.left;
            successor.left.parent = successor;
        }
    }

    protected Node<T> search(T value, Node<T> node) {
        if (node != null) {
            if (node.value == value)
                return node;
            else if (node.value.compareTo(value) > 0)
                return search(value, node.left);
            else
                return search(value, node.right);
        }
        return null;
    }

    @Override
    public boolean contains(T value) {
        return search(value, root) != null;
    }

    protected static class Node<T> {
        T value;
        Node<T> left, right, parent;

        public Node(T value) {
            this.value = value;
            left = right = parent = null;
        }
    }
}
