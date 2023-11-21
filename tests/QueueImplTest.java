import DataStructures.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class VectorQueueTest {
    public Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new VectorQueue<>();
    }

    @Test
    void testEnqueue() {
        queue.enqueue(10);
        assertEquals(1, queue.size());
        assertEquals(10, queue.dequeue());
    }

    @Test
    void testDequeue() {
        queue.enqueue(10);
        int popVal = queue.dequeue();
        assertEquals(10, popVal);
        assertEquals(0, queue.size());
    }


    @Test
    void testThrowExceptionDequeueEmpty() {
        assertThrows(RuntimeException.class, () -> queue.dequeue());
    }

    @Test
    void testMultiEnqueueDequeue() {
        queue.enqueue(10);
        queue.enqueue(11);
        queue.enqueue(12);
        assertEquals(3, queue.size());
        assertEquals(10, queue.dequeue());
        assertEquals(2, queue.size());
        assertEquals(11, queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals(12, queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    void testRecycle(){
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        while (!queue.empty())
            queue.dequeue();
        for (int i = 10; i < 13; i++)
            queue.enqueue(i);

        for (int i = 10; i < 13; i++)
            assertEquals(i, queue.dequeue());
        assertTrue(queue.empty());
    }
}

class QueueSTest extends VectorQueueTest{
    @BeforeEach
    void setUp(){
        super.setUp();
        queue = new QueueS<>();
    }

    @Test
    void testQueueEmpty(){
        assertTrue(queue.empty());
        queue.enqueue(10);
        assertFalse(queue.empty());
    }
}

class QueueLTest extends QueueSTest{
    @BeforeEach
    void setUp(){
        super.setUp();
        queue = new QueueL<>();
    }
}