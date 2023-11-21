import DataStructures.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class UnboundedVectorStackTest {
    public Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new VectorStack<>();
    }

    @Test
    void testPush() {
        stack.push(10);
        assertEquals(10, stack.pop());
    }

    @Test
    void testPop() {
        stack.push(15);
        assertEquals(15, stack.pop());
    }

    @Test
    void testEmpty() {
        assertTrue(stack.empty());
        stack.push(10);
        assertFalse(stack.empty());
    }

    @Test
    void testThrowExceptionWhenEmptyPop() {
        assertThrows(RuntimeException.class, () -> stack.pop());
    }

    @Test
    void testMultiplePushPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.size());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.size());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.size());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());
        assertEquals(1, stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void testRecycle(){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.empty())
            stack.pop();
        for (int i = 10; i < 13; i++)
            stack.push(i);

        for (int i = 12; i >= 10; i--)
            assertEquals(i, stack.pop());
        assertTrue(stack.empty());
    }

}

class BoundedVectorStackTest extends UnboundedVectorStackTest {
    @BeforeEach
    void setUp() {
        super.setUp();
        stack = new VectorStack<>(10);
    }

    @Test
    void testPushNotOutOfBound() {
        for (int i = 0; i < 10; i++)
            stack.push(i);

        for (int i = 9; i >= 0; i--)
            assertEquals(i, stack.pop());
    }

    @Test
    void testPushOutOfBound() {
        assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    for (int i = 0; i < 11; i++)
                        stack.push(i);
                }
        );
    }
}

class StackQTest extends UnboundedVectorStackTest{
    @BeforeEach
    void setUp(){
        super.setUp();
        stack = new StackQ<>();
    }
}

class StackLTest extends StackQTest{
    @BeforeEach
    void setUp(){
        super.setUp();
        stack = new StackL<>();
    }
}