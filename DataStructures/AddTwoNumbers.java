public class AddTwoNumbers {
    public class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode ptr = root;
        int result = 0;
        int carry = 0;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        while (true) {
            if (ptr1 == null && ptr2 != null) {
                ptr1 = new ListNode(0);
            } else if (ptr1 != null && ptr2 == null) {
                ptr2 = new ListNode(0);
            } else if (ptr1 == null && ptr2 == null) {
                if (carry != 0) {
                    ptr.next = new ListNode(carry);
                }
                break;
            } else {
                int sum = ptr1.val + ptr2.val + carry;
                carry = sum / 10;
                result = sum % 10;
                ListNode newNode = new ListNode(result);
                ptr.next = newNode;
                ptr = newNode;
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        return root.next;
    }
}
