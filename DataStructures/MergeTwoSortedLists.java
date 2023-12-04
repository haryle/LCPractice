public class MergeTwoSortedLists {

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

    public static void printNode(ListNode node){
        ListNode ptr = node;
        do{
            System.out.println(ptr.val);
            ptr = ptr.next;
        }while (ptr!=null);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode head = new ListNode(0);
        ListNode root = head;
        while (true){
            if (ptr1 == null){
                head.next = ptr2;
                break;
            }else if (ptr2 == null){
                head.next = ptr1;
                break;
            }else{
                if (ptr1.val < ptr2.val){
                    head.next = ptr1;
                    ptr1 = ptr1.next;
                }else{
                    head.next = ptr2;
                    ptr2 = ptr2.next;
                }
                head = head.next;
            }
        }
        return root.next;
    }

    public static void main(String[] argv){
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3, five);
        ListNode two = new ListNode(2, four);
        ListNode one = new ListNode(1, three);
        ListNode head = solution.mergeTwoLists(one, two);
        printNode(head);
    }
}
