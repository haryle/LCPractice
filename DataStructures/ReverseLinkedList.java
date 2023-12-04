public class ReverseLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){this.val=val; this.next=next;}
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = head;
        ListNode next = current.next;
        current.next = null;
        do{
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }while (next != null);
        return current;
    }

    public static void printNode(ListNode head){
        ListNode ptr = head;
        do{
            System.out.println(ptr.val);
            ptr = ptr.next;
        }while (ptr!=null);
    }

    public static void main(String[] argv){
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        printNode(one);
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode head = solution.reverseList(one);
        printNode(head);
    }
}
