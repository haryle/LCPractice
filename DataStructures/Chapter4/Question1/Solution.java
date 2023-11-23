package Chapter4.Question1;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static boolean traverse(Node node, List<Integer> leafHeights) {
        boolean leftIsBalance = true;
        boolean rightIsBalance = true;
        if (node.left != null) {
            node.left.height = node.height + 1;
            leftIsBalance = traverse(node.left, leafHeights);
        }
        if (node.right != null) {
            node.right.height = node.height + 1;
            rightIsBalance = traverse(node.right, leafHeights);
        }
        if (node.left == null && node.right == null) {
            if (leafHeights.isEmpty()) {
                leafHeights.add(node.height);
                return true;
            }
            else if (leafHeights.size() == 1) {
                if (leafHeights.contains(node.height))
                    return true;
                else if (leafHeights.get(0) == node.height - 1 || leafHeights.get(0) == node.height + 1) {
                    leafHeights.add(node.height);
                    return true;
                } else
                    return false;
            } else if (leafHeights.size() == 2) {
                return leafHeights.contains(node.height);
            } else {
                return false;
            }
        }
        return leftIsBalance && rightIsBalance;
    }

    public static boolean isBalance(Node root) {
        List<Integer> heights = new ArrayList<>();
        return traverse(root, heights);
    }

    public static class Node {
        public int value;
        public int height;
        public Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
            height = 0;
        }
    }
}
