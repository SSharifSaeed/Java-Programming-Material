import java.util.NoSuchElementException;
import java.util.Arrays;

public class Container<T> {
    private T[] elements;
    private int count;

    public Container(){
        elements = (T[]) new Object[1];
        count = 0;
    }

    public Container(int initialCapacity) {
        if(initialCapacity < 1){
            throw new IllegalArgumentException("Initial capacity must be at least 1");
        }
        elements = (T[]) new Object[initialCapacity];
        count = 0;
    }

    public void add(T element) {
        // If the Array is full, double the size
        if(count == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[count++] = element;
    }

    public T get(int index) {
        // Hint IndexOutOfBoundsException
        if (index >= 0 && index < count) {
            return elements[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public int size() {
        return count;
    }

    public boolean remove(T element) {
        for(int i = 0; i < count; i++) {
            if(elements[i].equals(element)) {
                // Shift elements
                System.arraycopy(elements, i + 1, elements, i, count - i - 1);
                count--;
                return true;
            }
        }
        throw new NoSuchElementException("Element does not exists!");
    }

}


