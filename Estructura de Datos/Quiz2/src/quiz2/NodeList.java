
package quiz2;

/**
 *
 * @author victorpointud
 */

public class NodeList {
    NodeList next;
    int element;
    int index;

    public NodeList() {
        this.next = null;
        this.element = 0;
        this.index = 0;
    }

    public NodeList getNext() {
        return next;
    }

    public void setNext(NodeList next) {
        this.next = next;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    
}
