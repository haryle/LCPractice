import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void printNode(ListNode node){
        ListNode ptr = node;
        do{
            System.out.println(ptr.val);
            ptr = ptr.next;
        }while (ptr != null);
    }

    public static void main(String[] argv){
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        ReorderList solution = new ReorderList();
        solution.reorderList(one);
        printNode(one);
    }

    public void reorderList(ListNode head) {
        List<ListNode> storage = new ArrayList<>();
        ListNode ptr = head;
        do{
            storage.add(ptr);
            ptr = ptr.next;
        }while (ptr != null);
        int start = 0;
        int end = storage.size() - 1;
        ptr = new ListNode(0);
        while (start < end){
            ptr.next = storage.get(start);
            storage.get(start).next = storage.get(end);
            ptr = storage.get(end);
            start++;
            end--;
        }
        if (start == end){
            ptr.next = storage.get(start);
            ptr = storage.get(start);
        }
        ptr.next = null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
