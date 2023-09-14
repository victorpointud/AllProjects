
package metromendeley;

/**
 *
 * @author victorpointud
 */

public class NodeObject {
    
    private InfoObject element;
    private NodeObject next;

    public NodeObject(InfoObject element) {
        
        this.next = null;
        this.element = element;
    }

    /**
     * @return the element
     */
    public InfoObject getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(InfoObject element) {
        this.element = element;
    }

    /**
     * @return the next
     */
    public NodeObject getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(NodeObject next) {
        this.next = next;
    } 
}
