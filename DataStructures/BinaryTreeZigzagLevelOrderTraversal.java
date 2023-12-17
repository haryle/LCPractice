import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] argv){
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        three.left = nine;
        three.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(solution.zigzagLevelOrder(three));


    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        boolean isLeft=true;
        queue.add(root);

        Deque<TreeNode> newLevel = new ArrayDeque<>();
        List<Integer> currentList = new ArrayList<>();
        TreeNode node;
        while (!queue.isEmpty()){
            if (isLeft){
                // Extract from head
                node = queue.removeFirst();
                if (node.left!=null)
                    newLevel.addLast(node.left);
                if(node.right!=null)
                    newLevel.addLast(node.right);
            }else{
                // Extract from tail
                node = queue.removeLast();
                if(node.right!=null)
                    newLevel.addFirst(node.right);
                if (node.left!=null)
                    newLevel.addFirst(node.left);
            }
            currentList.add(node.val);
            if (queue.isEmpty()){
                isLeft = !isLeft;
                result.add(currentList);
                currentList = new ArrayList<>();
                if (!newLevel.isEmpty()) {
                    queue = newLevel;
                    newLevel = new ArrayDeque<>();
                }
            }
        }
        return result;
    }
}
