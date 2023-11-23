package Chapter4.Question1;

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
        return root;
    }

    public Solution.Node testCase3() {
        Solution.Node root = new Solution.Node(6);
        root.left = new Solution.Node(5);
        root.right = new Solution.Node(7);
        root.left.left = new Solution.Node(2);
        root.left.right = new Solution.Node(5);
        root.left.left.left = new Solution.Node(1);
        return root;
    }

    public Solution.Node testCase4() {
        Solution.Node root = new Solution.Node(6);
        root.left = new Solution.Node(5);
        root.right = new Solution.Node(7);
        root.left.left = new Solution.Node(2);
        root.left.left.left = new Solution.Node(1);
        return root;
    }
    public Solution.Node testCase5() {
        Solution.Node root = new Solution.Node(6);
        root.left = new Solution.Node(5);
        root.right = new Solution.Node(7);
        root.left.left = new Solution.Node(2);
        root.left.right = new Solution.Node(3);
        root.left.left.left = new Solution.Node(1);
        return root;
    }

    public Solution.Node testCase6(){
        return new Solution.Node(1);
    }



    @Test
    void checkBalanceCase1() {
        assertTrue(Solution.isBalance(testCase1()));
    }

    @Test
    void checkBalanceCase2() {
        assertTrue(Solution.isBalance(testCase2()));
    }

    @Test
    void checkBalanceCase3() {
        assertFalse(Solution.isBalance(testCase3()));
    }

    @Test
    void checkBalanceCase4() {
        assertFalse(Solution.isBalance(testCase4()));
    }

    @Test
    void checkBalanceCase5() {
        assertFalse(Solution.isBalance(testCase5()));
    }

    @Test
    void checkBalanceCase6() {
        assertTrue(Solution.isBalance(testCase6()));
    }
}