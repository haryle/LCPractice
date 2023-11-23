package Chapter4.Question5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    public Solution.Node testCase1() {
        Solution.Node root = new Solution.Node(6);
        root.left = new Solution.Node(5);
        root.left.left = new Solution.Node(2);
        root.left.right = new Solution.Node(5);
        root.right = new Solution.Node(7);
        root.right.right = new Solution.Node(8);
        return root;
    }

    public Solution.Node testCase2() {
        Solution.Node root = new Solution.Node(6);
        root.left = new Solution.Node(5);
        root.left.left = new Solution.Node(2);
        root.left.right = new Solution.Node(5);
        root.right = new Solution.Node(7);
        root.right.right = new Solution.Node(8);
        root.right.left = new Solution.Node(5);
        return root;
    }

    public Solution.Node testCase3() {
        Solution.Node root = new Solution.Node(2);
        root.right = new Solution.Node(5);
        root.right.right = new Solution.Node(7);
        root.right.right.left = new Solution.Node(6);
        root.right.right.right = new Solution.Node(8);
        root.right.right.left.left = new Solution.Node(5);
        return root;
    }

    public Solution.Node testCase4() {
        Solution.Node root = new Solution.Node(20);
        root.left = new Solution.Node(10);
        root.right = new Solution.Node(30);
        root.left.right = new Solution.Node(25);
        return root;
    }


    @Test
    void checkBSTCase1() {
        assertTrue(Solution.isBST(testCase1()));
    }

    @Test
    void checkBSTCase2() {
        assertFalse(Solution.isBST(testCase2()));
    }

    @Test
    void checkBSTCase3() {
        assertTrue(Solution.isBST(testCase3()));
    }

    @Test
    void checkBSTCase4(){
        assertFalse(Solution.isBST(testCase4()));
    }

}