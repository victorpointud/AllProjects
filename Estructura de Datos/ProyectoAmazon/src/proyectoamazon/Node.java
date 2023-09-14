
package proyectoamazon;

/**
 *
 * @author victorpointud
 */
public class Node {
    
    // Métodos.
    
    private Object element;
    private Node next;

    public Node(Object element) {
        this.next = null;
        this.element = element;
    }

    // Getters y Setters.
    
    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    } 
}

