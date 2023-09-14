
package metromendeley;

/**
 *
 * @author victorpointud
 */

public class Nodo {
    
    private Nodo left; 
    private Nodo right;
    private Nodo next; 
    private InfoObject data; 
    
    public Nodo(InfoObject data){
        
        this.next = null; 
        this.data = data; 
    }

    /**
     * @return the next
     */
    public Nodo getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Nodo next) {
        this.next = next;
    }

    /**
     * @return the name
     */
    public InfoObject getData() {
        return data;
    }

    /**
     * @param data the name to set
     */
    public void setData(InfoObject data) {
        this.data = data;
    }

    /**
     * @return the left
     */
    public Nodo getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Nodo left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public Nodo getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Nodo right) {
        this.right = right;
    }
    
    /**
     *
     * @return if is Sheet
     */
    public boolean isSheet(){
        return this.getRight()==null && this.getLeft()==null;
    }
}

