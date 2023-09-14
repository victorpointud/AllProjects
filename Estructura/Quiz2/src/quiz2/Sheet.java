
package quiz2;

/**
 *
 * @author victorpointud
 */

public class Sheet {
    NodeSheet head;
    NodeSheet last;
    int total;
    
    public Sheet() {

       this.total = 0;
       this.head = null;
       this.last = null;
       
    }

    public NodeSheet getHead() {
        return head;
    }

    public void setHead(NodeSheet head) {
        this.head = head;
    }

    public NodeSheet getLast() {
        return last;
    }

    public void setLast(NodeSheet last) {
        this.last = last;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
    
    public void insert(){
       
        NodeSheet newNode = new NodeSheet(this.getTotal());
        if (this.isEmpty()){
            this.head = this.last = newNode;
        }
        else{
            this.getLast().setNext(newNode);
            newNode.setPrev(this.getLast());
            this.setLast(newNode);
        }
        this.total ++;
    }
}
