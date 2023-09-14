
package proyectoamazon;

/**
 *
 * @author victorpointud
 */
public class NodeProduct {
    
    // Métodos.
    
    private Product element;
    private NodeProduct next;

    public NodeProduct (Product element) {
        this.next = null;
        this.element = element;
    }
    
    // Getters y Setters.
    
    public Product getElement() {
        return element;
    }

    public void setElement(Product element) {
        this.element = element;
    }


    public NodeProduct getNext() {
        return next;
    }

    public void setNext(NodeProduct next) {
        this.next = next;
    }
    
}
