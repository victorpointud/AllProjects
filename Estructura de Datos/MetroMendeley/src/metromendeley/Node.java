
package metromendeley;

/**
 *
 * @author victorpointud
 */

public class Node {
    
    private String element;
    private Node next;

    public Node(String element) {
        
        this.next = null;
        this.element = element;
    }

    /**
     * @return the element
     */
    public String getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(String element) {
        this.element = element;
    }

    /**
     * @return the next
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node next) {
        this.next = next;
    } 
}
