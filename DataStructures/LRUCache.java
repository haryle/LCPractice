import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static class Node {
        int value;
        int key;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public Node head = null;
    public Node tail = null;
    public final Map<Integer, Node> LUT = new HashMap<>();

    public int size = 0;
    public final int capacity;

    public void moveNodeToTail(Node node){
        if (size == 1 || node == tail)
            return;
        if (node == head)
            head = head.next;
        Node prev = node.prev;
        Node next = node.next;
        if (prev != null)
            prev.next = next;
        if (next!= null)
            next.prev = prev;
        addNodeToTail(node);
    }

    public void addNodeToTail(Node node){
        if (size == 0){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!LUT.containsKey(key))
            return -1;
        Node node = LUT.get(key);
        moveNodeToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (LUT.containsKey(key)){
            LUT.get(key).value = value;
            moveNodeToTail(LUT.get(key));
        }else{
            Node node = new Node(key, value);
            LUT.put(key, node);
            if (size < capacity){
                addNodeToTail(node);
                size++;
            }else{
                if (size == 1){
                    size = 0;
                    LUT.clear();
                    addNodeToTail(node);
                    LUT.put(key, node);
                    size = 1;
                }else{
                    LUT.remove(head.key);
                    head = head.next;
                    head.prev = null;
                    addNodeToTail(node);
                }
            }
        }
    }

    public static void test1(){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

    public static void test2(){
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2,1);
        lRUCache.get(2);
        lRUCache.put(3,2);
        lRUCache.get(2);
        lRUCache.get(3);
    }

    public static void main(String[] argv){
        test2();
    }

}
