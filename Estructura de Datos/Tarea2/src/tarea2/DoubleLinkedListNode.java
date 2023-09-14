
package tarea2;

/**
 *
 * @author victorpointud
 */

public class DoubleLinkedListNode <T> {
    T data;
    DoubleLinkedListNode <T> next;
    DoubleLinkedListNode <T> prev;

    public DoubleLinkedListNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleLinkedListNode<T> next) {
        this.next = next;
    }

    public DoubleLinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedListNode<T> prev) {
        this.prev = prev;
    }
    
}
