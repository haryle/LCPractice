import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public static void printNode(ListNode node){
        ListNode ptr = node;
        do{
            System.out.println(ptr.val);
            ptr = ptr.next;
        } while (ptr != null);
    }
    public static void main(String[] argv) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        ListNode root = solution.removeNthFromEnd(one, 5);
        printNode(root);


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> array = new ArrayList<>();
        ListNode ptr = head;
        do {
            array.add(ptr);
            ptr = ptr.next;
        } while (ptr != null);

        if (n == array.size()) {
            if (array.size() == 1)
                return null;
            return array.get(1);
        } else if (n == 1)
            array.get(array.size() - 2).next = null;
        else
            array.get(array.size() - n - 1).next = array.get(array.size() - n + 1);
        return array.get(0);
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
