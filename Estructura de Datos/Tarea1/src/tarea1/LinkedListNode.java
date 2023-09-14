
package tarea1;

public class LinkedListNode <T> {
    T data;
    LinkedListNode <T> next;

    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
    
    
}
