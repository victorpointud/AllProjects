
package quiz2;

/**
 *
 * @author victorpointud
 */

public class NodeSheet {
    Tree data;
    NodeSheet next;
    NodeSheet prev;
    int index;
    
    public NodeSheet(int index) {
        this.data = null;
        this.next = null;
        this.prev = null;
        this.index = index;
    }

    public Tree getData() {
        return data;
    }

    public void setData(Tree data) {
        this.data = data;
    }

    public NodeSheet getNext() {
        return next;
    }

    public void setNext(NodeSheet next) {
        this.next = next;
    }

    public NodeSheet getPrev() {
        return prev;
    }

    public void setPrev(NodeSheet prev) {
        this.prev = prev;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    
}

