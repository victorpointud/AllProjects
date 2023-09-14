
package tarea1;

/**
 *
 * @author victorpointud
 */

    public class LinkedList <T> {
        LinkedListNode <T> head;
        int size;
        
        LinkedList(){
            this.head = null;
            this.size = 0;
        }

    public LinkedListNode getHead() {
        return head;
    }

    public void setHead(LinkedListNode <T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public LinkedListNode <T> searchLinkedListNode( T data) {
        if (this.head == null) {
            return null;
        }
        LinkedListNode currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.data == data) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    
    public LinkedListNode <T> getFirst() {
        if (this.head == null) {
            return null;
        }
        else{
            return this.head;
        }
    }
    
    public LinkedListNode <T> getLast(){
        if(this.head == null) {
            return null;
        }
        
        LinkedListNode last = this.head;
        LinkedListNode control = this.head;
        
        while(control != null){
            last = control;
            control = last.next;
        }
        return last;
    }
    
    public LinkedListNode <T> getLinkedListNodeAt(int pos){
        if(this.head == null || (this.size -1) < pos){
            return null;
        }
        
        LinkedListNode control = this.head;
        int x = 0;
        
        while(control != null){
            if(x == pos){
                break;
            }
            x++;
            control = control.next;
        }
        return control;
        
    }
    
    public void printLinkedList() {
        if (this.size == 0) {
            System.out.println("the list is empty.");
            return;
        }
        System.out.print("{ ");
        LinkedListNode<T> current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        
        System.out.println("} ");
        System.out.println();
    }
    
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    public void add(int data){
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.next = null;

        if(this.head == null){
            this.head = newNode;
        }
        else{
            LinkedListNode last = getLast();
            last.next = newNode;

        }
        this.size ++;
    }
    
    public void addFirst(T data){
        
        LinkedListNode node = new LinkedListNode(data);;
        if (isEmpty()) {
            
            setHead(node);
        } 
        else {
            
            node.setNext(getHead());
            setHead(node);
        }
        this.size ++;
    }
    
    public void addLast(T data) {
        
        LinkedListNode newNode = new LinkedListNode(data);
        if (isEmpty()) {
            setHead(newNode);
        } 
        else {
            LinkedListNode pointer = getHead();
            while (pointer.next != null) {
               pointer = pointer.next;
            }
        pointer.setNext(newNode);
        }
        this.size ++;
    }
    
    public void order(){
        LinkedList linkedlist = new LinkedList();
        while(this.head != null){
            LinkedListNode pointer = this.head;
            LinkedListNode prevMin = null;
            LinkedListNode min = pointer;
            while (pointer.next != null){
                int ja = (int) pointer.next.data;
                int ja2 = (int) min.data;
                
                if(ja < ja2){
                    prevMin = pointer;
                    min = pointer.next;
                }
                pointer = pointer.next;
                
            }
            
            if(prevMin != null){
                prevMin.setNext(min.next);
            }
            else{
                this.setHead(min.next);
            }
            LinkedListNode aux = new LinkedListNode(min.data);
            linkedlist.addLast(aux.data);
            linkedlist.addFirst(aux);
            System.out.print("{ "  + aux.data + " } ");
            
        }
        System.out.println("");
        System.out.println("");
    }
}