import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements QueueADT<T> {
    private LinkedNode<T> back;  // Reference to the back of the queue
    private LinkedNode<T> front; // Reference to the front of the queue
    private int size;            // Number of elements in the queue

    public LinkedQueue() {
        this.back = null;
        this.front = null;
        this.size = 0;
    }

    public void clear() {
        front = null;
        back = null;
        size = 0;
    }

    public boolean contains(T value) {
        LinkedNode<T> current = front;
        while (current != null) {
            if (current.getData().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T value = front.getData();
        front = front.getNext();
        if (front == null) {
            back = null;
        }
        size--;
        return value;
    }

    public void enqueue(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Null values are not allowed.");
        }
        LinkedNode<T> newNode = new LinkedNode<>(value, null);
        if (back != null) {
            back.setNext(newNode);
        }
        back = newNode;
        if (front == null) {
            front = back;
        }
        size++;
    }

    public ArrayList<T> getList() {
        ArrayList<T> list = new ArrayList<>();
        LinkedNode<T> current = front;
        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }
        return list;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return front.getData();
    }

    public int size() {
        return size;
    }
}