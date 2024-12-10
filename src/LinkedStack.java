import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements StackADT<T> {
    private LinkedNode<T> top; // A reference to the LinkedNode currently at the top of the stack.

    /**
     * Adds a new element to the top of this stack, assumed to be non-null.
     *
     * @param value the element to be added
     */
    public void push(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Null values are not allowed.");
        }
        top = new LinkedNode<>(value, top);
    }

    /**
     * Removes and returns the value added to this stack most recently.
     *
     * @return the value at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T value = top.getData();
        top = top.getNext();
        return value;
    }

    /**
     * Accesses the value added to this stack most recently, without modifying the stack.
     *
     * @return the value at the top of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return top.getData();
    }

    /**
     * Returns true if this stack contains no elements.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns true if this stack contains the element, false otherwise.
     *
     * @param value the element to search for
     * @return true if the element is found, false otherwise
     */
    public boolean contains(T value) {
        LinkedNode<T> current = top;
        while (current != null) {
            if (current.getData().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Creates a copy of the current contents of this stack in the order they are present here, in ArrayList form.
     *
     * @return an ArrayList containing the elements of the stack
     */
    public ArrayList<T> getList() {
        ArrayList<T> list = new ArrayList<>();
        LinkedNode<T> current = top;
        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }
        return list;
    }
}
