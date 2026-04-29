public class DynamicArrays<T> {

    private T[] data;
    private int size;
    private int capacity;

    public DynamicArrays(int initialCapacity) {
        if (initialCapacity <= 0) {
            initialCapacity = 10;
        }
        this.capacity = initialCapacity;
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    // default Constructor
    public DynamicArrays() {
        this(10);
    }

    // 1. Add element at the end (most important operation)
    public void add(T element) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        data[size] = element;
        size++;

    }

    // 2. Insert at specific index
    public void insertAt(T element, int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == capacity) {
            resize(capacity * 2);
        }

        // shift elements to right
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        // [1,2,3,4]
        // insertAt index 1
        // i = 4 , 4 > 1 , i--
        // data[4] = data[4-1] , [1,2,3,4,4]
        // data[3] = data[3-1] , [1,2,3,3,4]
        // data[2] = data[2-1] , [1,2,2,3,4]
        // now loop will be terminated because i = 1 > 1 (false)
        data[index] = element;
        size++;

    }

    // 3. Get element
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return data[index];
    }

    // 4. Set / Update element
    public void setAt(T element, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        data[index] = element;
    }

    // 5. Remove element at index
    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removed = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];

        }
        data[size - 1] = null;
        size--;
        if (size < capacity / 4 && capacity > 10) {
            resize(capacity / 2);
        }
        return removed;

    }

    // resize
    private void resize(int newCapacity) {
        if (newCapacity < size) {
            throw new IllegalArgumentException("New capacity cannot be less than size");
        }

        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;

    }

    // Print
    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) {
                System.out.print(", ");

            }
        }

        System.out.println("]  (size=" + size + ", capacity=" + capacity + ")");
    }

}
