
package proyectoamazon;

/**
 *
 * @author victorpointud
 */
public class NodeCart {
    
    // Métodos.
    
    private ProductCart element;
    private NodeCart next;

    public NodeCart (ProductCart element) {
        this.next = null;
        this.element = element;
    }
    
    // Getters y Setters.
    
    public ProductCart getElement() {
        return element;
    }

    public void setElement(ProductCart element) {
        this.element = element;
    }

    public NodeCart getNext() {
        return next;
    }

    public void setNext(NodeCart next) {
        this.next = next;
    }
}
