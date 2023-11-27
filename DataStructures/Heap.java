import java.util.Comparator;
import java.util.List;

import static java.lang.Math.ceil;

public class Heap<T> {
    public int size;
    protected int heapSize;
    protected List<T> array;
    protected Comparator<T> comparator;

    public Heap(List<T> array, Comparator<T> comparator) {
        this.array = array;
        size = array.size();
        this.comparator = comparator;
        buildHeap();
    }

    public List<T> getArray() {
        return array;
    }

    protected int getParentIndex(int index) {
        return (int) (ceil((double) index / 2) - 1);
    }

    protected int getLeftIndex(int index) {
        return 2 * index + 1;
    }

    protected int getRightIndex(int index) {
        return 2 * (index + 1);
    }

    protected void heapify(int index) {
        int leftIndex = getLeftIndex(index);
        int rightIndex = getRightIndex(index);
        int largestIndex = index;
        if (leftIndex < heapSize && comparator.compare(array.get(leftIndex),
                array.get(index)) > 0)
            largestIndex = leftIndex;
        if (rightIndex < heapSize && comparator.compare(array.get(rightIndex),
                array.get(largestIndex)) > 0)
            largestIndex = rightIndex;
        if (largestIndex != index) {
            T temp = array.get(index);
            array.set(index, array.get(largestIndex));
            array.set(largestIndex, temp);
            heapify(largestIndex);
        }
    }

    protected void buildHeap() {
        heapSize = this.array.size();
        for (int i = getParentIndex(this.array.size() - 1); i >= 0; i--)
            heapify(i);
    }

    public void sort() {
        for (int i = array.size() - 1; i >= 1; i--) {
            T temp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, temp);
            heapSize--;
            heapify(0);
        }
    }

    public int size() {
        return this.size;
    }
}
