package tail;

/**
 *
 * @author victorpointud
 */

public class TailNode <T> {
    T data;
    TailNode <T> prev;
    TailNode <T> next;

    public TailNode (T data) {
        this.data = data;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TailNode<T> getPrev() {
        return prev;
    }

    public void setPrev(TailNode<T> prev) {
        this.prev = prev;
    }

    public TailNode<T> getNext() {
        return next;
    }

    public void setNext(TailNode<T> next) {
        this.next = next;
    }
    
}
