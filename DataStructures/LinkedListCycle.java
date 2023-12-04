import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        Set<ListNode> storage  = new HashSet<>();
        ListNode ptr = head;
        do{
            if (storage.contains(ptr))
                return true;
            storage.add(ptr);
            ptr = ptr.next;
        }while (ptr != null);
        return false;
    }
}
