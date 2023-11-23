package Chapter4.Question5;

public class Solution {
    private static boolean isBST(Node node, int lower, int upper) {
        boolean leftBST = true;
        boolean rightBST = true;
        if (node.left != null) {
            if (node.left.value > node.value || node.left.value < lower)
                return false;
            leftBST = isBST(node.left, lower, node.value);
        }
        if (node.right != null) {
            if (node.right.value < node.value || node.right.value > upper)
                return false;
            rightBST = isBST(node.right, node.value, upper);
        }
        return leftBST && rightBST;
    }

    public static boolean isBST(Node root) {
        int lower = Integer.MIN_VALUE;
        int upper = Integer.MAX_VALUE;
        return isBST(root, lower, upper);
    }

    public static class Node {
        public int value;
        public Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

}
