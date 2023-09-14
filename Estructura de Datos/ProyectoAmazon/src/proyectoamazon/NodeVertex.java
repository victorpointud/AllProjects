
package proyectoamazon;

/**
 *
 * @author victorpointud
 */
public class NodeVertex {
    
    // Métodos.
    
    private String[] element;
    private NodeVertex next;

    public NodeVertex(String[] element) {
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

    public NodeVertex getNext() {
        return next;
    }

    public void setNext(NodeVertex next) {
        this.next = next;
    } 
}

