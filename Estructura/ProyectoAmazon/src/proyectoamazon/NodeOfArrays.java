
package proyectoamazon;

/**
 *
 * @author victorpointud
 */
public class NodeOfArrays {
    
    // Métodos.
    
    private String[] element;
    private NodeOfArrays next;

    public NodeOfArrays (String[] element) {
        this.next = null;
        this.element = element;
    }

    // Getters y Setters.
    
    public String[] getElement() {
        return element;
    }

    public void setElement(String[] element) {
        this.element = element;
    }

    public NodeOfArrays getNext() {
        return next;
    }

    public void setNext(NodeOfArrays next) {
        this.next = next;
    }
    
}
