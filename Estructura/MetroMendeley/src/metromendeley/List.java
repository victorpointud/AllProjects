
package metromendeley;

/**
 *
 * @author victorpointud
 */

public class List {
    
    private Node head;
    private int length;

    public List(Node head) {
        
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
    public void setHead(Node head) {
        
        this.head = head;
    }

    /**
     *
     * @return the head
     */
    public Node getHead() {
        
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
    public void insertStart(String element){
        
        Node node = new Node(element);
        if (isEmpty()) {
            
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
    public void insertEnd(String element) {
        
        Node node = new Node(element);
        if (isEmpty()) {
            
            setHead(node);
        } 
        else {
            
            Node pointer = getHead();
            while (pointer.getNext() != null) {
                
               pointer = pointer.getNext();
            }
        pointer.setNext(node);
        }
        length++;
        }
        
    /**
     *
     * @return the empty
     */
    public boolean isEmpty() {
        
        return getHead() == null;
    }
    
    /**
     * print the list
     */
    public void printList() {
        
        Node pointer = getHead();
        if (isEmpty()) {
            System.out.println("La lista esta vacia.");} else {
            
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
    public void deleteFirst() {
        
        Node pointer = getHead();
        if (!isEmpty()) {
            
            setHead(pointer.getNext());
            pointer.setNext(null);
        }
    length--;
    }
    
    /**
     * delete de last
     */
    public void deleteLast() {
        
        Node pointer = getHead();
        if (!isEmpty()) {
            
            while (pointer.getNext().getNext() != null) {
                
                pointer = pointer.getNext();
            }
        pointer.setNext(null);
        }
    length--;
    }
   
}

