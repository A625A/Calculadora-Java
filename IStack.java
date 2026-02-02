public interface IStack<T> {
    
    /**
     * Pushes an element onto the top of this stack.
     * 
     * @param value the element to be pushed onto the stack
     */
    void push(T value);
    
    /**
     * Removes and returns the element at the top of this stack.
     * 
     * @return the element at the top of this stack
     */
    T pop();
    
    /**
     * Returns the element at the top of this stack without removing it.
     * 
     * @return the element at the top of this stack
     */
    T peek();
    
    /**
     * Tests if this stack is empty.
     * 
     * @return true if this stack contains no elements; false otherwise
     */
    boolean isEmpty();
    
    /**
     * Returns the number of elements in this stack.
     * 
     * @return the number of elements in this stack
     */
    int size();
    
    /**
     * Removes all elements from this stack.
     */
    void clear();
}