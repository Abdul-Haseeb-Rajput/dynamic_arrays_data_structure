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

    private void resize(int newCapacity) {
        if (newCapacity < capacity) {
            newCapacity = size;
        }

        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;

    }

}
