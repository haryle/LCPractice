import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node, Integer> forwardMap = new HashMap<>();
        Map<Integer, Node> reverseMap = new HashMap<>();
        int index = 0;
        Node ptr = head;
        Node root = new Node(0);
        Node current = root;
        do {
            forwardMap.put(ptr, index);
            current.next = new Node(ptr.val);
            current = current.next;
            ptr = ptr.next;
            reverseMap.put(index, current);
            index++;
        } while (ptr != null);

        ptr = head;
        current = root.next;
        do {
            if (ptr.random != null) {
                index = forwardMap.get(ptr.random);
                current.random = reverseMap.get(index);
            }
            ptr = ptr.next;
            current = current.next;
        } while (ptr != null);
        return root.next;
    }

}
