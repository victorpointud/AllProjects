
package parcial1.victor.pointud;

/**
 *
 * @author victorpointud
 */

public class CircularListNode <T> {
    T data;
    CircularListNode <T> next;
    CircularListNode <T> prev;

    public CircularListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CircularListNode getNext() {
        return next;
    }

    public void setNext(CircularListNode next) {
        this.next = next;
    }

    public CircularListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(CircularListNode<T> prev) {
        this.prev = prev;
    }
    
    
    
}
