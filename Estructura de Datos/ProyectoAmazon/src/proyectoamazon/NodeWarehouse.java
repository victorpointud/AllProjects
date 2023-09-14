
package proyectoamazon;

/**
 *
 * @author victorpointud
 */
public class NodeWarehouse {
    
    // Métodos.
    
    private Warehouse element;
    private NodeWarehouse next;

    public NodeWarehouse(Warehouse element) {
        this.next = null;
        this.element = element;
    }

    // Getters y Setters.
    
    public Warehouse getElement() {
        return element;
    }

    public void setElement(Warehouse element) {
        this.element = element;
    }


    public NodeWarehouse getNext() {
        return next;
    }

    public void setNext(NodeWarehouse next) {
        this.next = next;
    } 
}
