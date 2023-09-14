
package metromendeley;

/**
 *
 * @author victorpointud
 */

public class ListObject {
    private NodeObject head;
    private int length;

    public ListObject(NodeObject head) {
        
        this.head = head;
        if (head != null) {
            
            this.length = 1;
        } 
        else {
            
            this.length = 0;
        }       
    }

    /**
     *
     * @param head the head to set
     */
    public void setHead(NodeObject head) {
        
        this.head = head;
    }

    /**
     *
     * @return the head
     */
    public NodeObject getHead() {
        
        return head;
    }

    /**
     *
     * @return the length
     */
    public int getLength() {
        
        return length;
    }
    
    /**
     *
     * @param element the start inserted
     */
    public void insertStart2(InfoObject element){
        
        NodeObject node = new NodeObject(element);
        if (isEmpty2()) {
            
            setHead(node);
        } 
        else {
            
            node.setNext(getHead());
            setHead(node);
        }
        length++;
    }
    
    /**
     *
     * @param element the end inserted
     */
    public void insertEnd2(InfoObject element) {
        
        NodeObject node = new NodeObject(element);
        if (isEmpty2()) {
            
            setHead(node);
        } 
        else {
            
            NodeObject pointer = getHead();
            while (pointer.getNext() != null) {
                
               pointer = pointer.getNext();
            }
        pointer.setNext(node);
        }
        length++;
        }
        
    /**
     *
     * @return empty
     */
    public boolean isEmpty2() {
        
        return getHead() == null;
    }
    
    /**
     * print list
     */
    public void printList2() {
        
        NodeObject pointer = getHead();
        if (isEmpty2()) {
            
            System.out.println("La lista esta vacia");} else {
        while (pointer.getNext() != null) {
            
            System.out.println(pointer.getElement());
            pointer = pointer.getNext();
        }
        System.out.println(pointer.getElement());
        }
    }
    
    /**
     * delete the first
     */
    public void deleteFirst2() {
        
        NodeObject pointer = getHead();
        if (!isEmpty2()) {
            
            setHead(pointer.getNext());
            pointer.setNext(null);
        }
    length--;
    }
    
    /**
     * delete the last
     */
    public void deleteLast2() {
        
        NodeObject pointer = getHead();
        if (!isEmpty2()) {
            
            while (pointer.getNext().getNext() != null) {
                
                pointer = pointer.getNext();
            }
        pointer.setNext(null);
        }
    length--;
    }
   
}

