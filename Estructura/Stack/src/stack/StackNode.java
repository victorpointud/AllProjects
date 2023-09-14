
package stack;

/**
 *
 * @author victorpointud
 */

public class StackNode <T> {
    T data;
    StackNode <T> next;

    public StackNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public StackNode <T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }

}