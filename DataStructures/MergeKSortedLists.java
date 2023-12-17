public class MergeKSortedLists {
    public static void main(String[] argv) {
        MergeKSortedLists sol = new MergeKSortedLists();
        sol.mergeKLists(new ListNode[3]);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if (size == 0)
            return null;
        int[] finished = new int[size];

        int allMerged = 0;
        ListNode root = new ListNode();
        ListNode current = root;
        while (allMerged < size) {
            int minVal = Integer.MAX_VALUE;
            int minIndex = -1;
            ListNode minNode = null;
            for (int i = 0; i < size; i++) {
                if (finished[i] != 1) {
                    if (lists[i] == null) {
                        finished[i] = 1;
                        allMerged += 1;
                    } else {
                        int value = lists[i].val;
                        if (value < minVal) {
                            minVal = value;
                            minIndex = i;
                            minNode = lists[i];
                        }
                    }
                }
            }
            if (minIndex != -1)
                lists[minIndex] = lists[minIndex].next;
            current.next = minNode;
            current = current.next;
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
