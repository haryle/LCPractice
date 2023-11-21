package DataStructures;

public interface List<T> {

    /**
     * Get size of current list
     *
     * @return number of elements
     */
    public int size();

    /**
     * Get the index of current key
     *
     * @param key - search key
     * @return -1 if key not found otherwise index
     */
    public int search(T key);

    /**
     * Return the value of the node at a given index
     *
     * @param index - index integer
     * @return node value or throw IndexOutOfBound error
     */
    public T valueAt(int index);

    /**
     * Prepend a new node with value = key at the head of the list
     *
     * @param key - new value to add
     */
    public T prepend(T key);

    /**
     * Append a new node with value = key at the end of the list
     *
     * @param key - new value to add
     */
    public T append(T key);

    /**
     * Insert new node at index
     *
     * @param value - value of new node
     * @param index - exact index to add
     */
    public T insert(T value, int index);

    /**
     * Remove the first occurrence of key
     *
     * @param key - key to remove
     */
    public void delete(T key);

    /**
     * Remove value at given index
     *
     * @param index - index at element
     */
    public void deleteAt(int index);
}

