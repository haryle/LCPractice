import java.util.Stack;

public class ReverseNodesInKGroup {

    public static void main(String[] argv){
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();

    }


    public static ListNode reverseStack(Stack<ListNode> stack, ListNode stackCurrent, ListNode stackPrev){
        while (!stack.empty()) {
            stackCurrent = stack.pop();
            stackCurrent.next = null;
            assert stackPrev != null;
            stackPrev.next = stackCurrent;
            stackPrev = stackCurrent;
        }
        return stackCurrent;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode root = new ListNode();
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        ListNode prev = root;
        while (current != null) {
            stack.push(current);
            current = current.next;
            if (stack.size() == k) {
                prev = reverseStack(stack, null, prev);
            }
        }
        if (!stack.empty()){
            ListNode node = stack.pop();
            while (!stack.empty()){
                node = stack.pop();
            }
            prev.next = node;
        }
        return root.next;
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
