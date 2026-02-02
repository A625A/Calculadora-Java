import java.util.Vector;

public class Vstack<T> implements IStack<T> {
    private Vector<T> data = new Vector<>();

    public void push(T value) {
        data.add(value);
    }
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("El Stack esta vacio");
        }
        return data.remove(data.size() - 1);
    }
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("El Stack esta vacio");
        }
        return data.get(data.size() - 1);
    }
    public boolean isEmpty() {
        return data.isEmpty();  
}
    public int size() {
        return data.size();
    }
    public void clear() {
        data.clear();
    }
}
