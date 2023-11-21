import DataStructures.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    public List<Integer> integerList;

    void setUp() {
        integerList = new LinkedList<>();
    }

    @BeforeEach
    void addData() {
        setUp();
        integerList.append(10);
        integerList.append(11);
        integerList.append(12);
        integerList.append(13);
    }

    @AfterEach
    void clearData() {
        for (int i = integerList.size() - 1; i >= 0; i--)
            integerList.deleteAt(i);
    }

    @Test
    void testSize() {
        assertEquals(4, integerList.size());
    }

    @Test
    void testAppend() {
        integerList.append(14);
        assertEquals(14, integerList.valueAt(integerList.size() - 1));
        assertEquals(5, integerList.size());
    }

    @Test
    void testPrepend() {
        integerList.prepend(9);
        assertEquals(9, integerList.valueAt(0));
        assertEquals(5, integerList.size());
    }

    @Test
    void testInsert() {
        integerList.insert(20, 1);
        assertEquals(20, integerList.valueAt(1));
        assertEquals(5, integerList.size());
    }

    @Test
    void testDelete() {
        integerList.delete(10);
        assertEquals(3, integerList.size());
        assertEquals(11, integerList.valueAt(0));
    }

    @Test
    void testDeleteAt() {
        clearData();
        assertEquals(0, integerList.size());
    }

    @Test
    void testIndexingEmptyArrayThrowsException() {
        clearData();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.valueAt(2);
        });
    }

    @Test
    void testNegativeIndexingThrowsException() {
        clearData();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.valueAt(-1);
        });
    }

    @Test
    void testDeleteAtInvalidIndexThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.deleteAt(10));
    }

    @Test
    void testDeleteNonExistValue() {
        integerList.delete(100);
        assertEquals(4, integerList.size());
    }

    @Test
    void testRecycle(){
        clearData();
        for (int i = 0; i < 5; i++){
            integerList.append(i);
            assertEquals(i, integerList.valueAt(i));
        }
    }

}

class DoubleLinkedListTest extends LinkedListTest {
    void setUp() {
        integerList = new DoubleLinkedList<>();
    }
}