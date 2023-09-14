
package quiz2;

/**
 *
 * @author victorpointud
 */

public class List {
    NodeList head;
    int total;

    public List() {
        this.head = null;
        this.total = 0;
    }

    public NodeList getHead() {
        return head;
    }

    public void setHead(NodeList head) {
        this.head = head;
    }
    
    public void insert(int element){
        NodeList newNode = new NodeList();
        newNode.setElement(element);
        if (isEmpty()){
            this.setHead(newNode);
            this.total++;
        }
        else{
            NodeList pointer;
            pointer = this.getHead();
            while(pointer.getNext() != null){ 
                pointer = pointer.getNext();
            }
            pointer.setNext(newNode);
            this.total++;
        }
    }
    
    public boolean isEmpty(){
        return this.getHead() == null;
    }
    
    public void delete(NodeList node){
        if (this.head == null || node == null){
            return;
        }
        NodeList control = this.head;
        NodeList temp = null;
        
        if(node == head){
            temp = this.head;
            this.head = this.head.next;
            
            temp = null;
        }
        else {
            while(control.next != node){
                control = control.next;
            }
            temp = control.next;
            control.next = temp.next;
            temp = null;
        }
        this.total--;
    }
    
}
