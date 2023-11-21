import DataStructures.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    public BinaryTree<Integer> bst;

    @BeforeEach
    void setUp(){
        bst = new BST<>();
        bst.add(10);
        bst.add(15);
        bst.add(7);
        bst.add(9);
        bst.add(8);
        bst.add(4);
        bst.add(5);
        bst.add(6);
        bst.add(11);
    }

    @Test
    void testInsert(){
        bst.print();
        assertEquals(9, bst.size());
        int[] array = {4,5,6,7,8,9,10,11,15};
        List<Integer> bstArr = bst.toList();
        for (int i = 0; i < array.length; i++)
            assertEquals(array[i], bstArr.get(i));
    }

    @Test
    void testContains(){
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(11));
        assertTrue(bst.contains(15));
    }

    @Test
    void testNotContain(){
        assertFalse(bst.contains(100));
    }

    @Test
    void testRemoveNodeWithOnlyLeft(){
        bst.remove(15);
        int array[] = {4,5,6,7,8,9,10,11};
        for (int i = 0; i < array.length; i++)
            assertEquals(array[i], bst.toList().get(i));
        assertEquals(array.length, bst.toList().size());
    }

    @Test
    void testRemoveNodeWithOnlyRight(){
        bst.remove(5);
        int array[] = {4,6,7,8,9,10,11,15};
        for (int i = 0; i < array.length; i++)
            assertEquals(array[i], bst.toList().get(i));
        assertEquals(array.length, bst.toList().size());
    }

    @Test
    void testRemoveNodeBoth(){
        bst.remove(10);
        int array[] = {4,5,6,7,8,9,11,15};
        for (int i = 0; i < array.length; i++)
            assertEquals(array[i], bst.toList().get(i));
        assertEquals(array.length, bst.toList().size());
    }

}