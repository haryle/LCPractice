import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeapTest {
    Heap<Integer> heap;
    Comparator<Integer> arrayComparator;

    public List<Integer> testCase1() {
        return new ArrayList<>(List.of(5, 13, 2, 25, 7, 17, 20, 8, 4));
    }

    public List<Integer> testCase2() {
        return new ArrayList<>(List.of(16, 14, 10, 8, 7, 9, 3, 2, 4, 1));
    }

    public List<Integer> testCase3() {
        return new ArrayList<>(List.of(27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0));
    }

}

class MinHeapTest extends HeapTest {
    @BeforeEach
    void setUp() {
        arrayComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
    }

    void runTestCase(List<Integer> array) {
        heap = new Heap<>(array, arrayComparator);
        heap.sort();
        List<Integer> sortedList = new ArrayList<>(array);
        sortedList.sort(arrayComparator);
        assertEquals(array.size(), heap.size());
        for (int i = 0; i < heap.size(); i++) {
            assertEquals(sortedList.get(i), heap.getArray().get(i));
        }
    }

    @Test
    void runTest1(){
        runTestCase(testCase1());
    }

    @Test
    void runTest2(){
        runTestCase(testCase2());
    }


    @Test
    void runTest3(){
        runTestCase(testCase3());
    }
}

class MaxHeapTest extends MinHeapTest{
    @BeforeEach
    void setUp() {
        arrayComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
    }
}