
package tarea2;

/**
 *
 * @author victorpointud
 */

public class DoubleLinkedList <T> {
  
    DoubleLinkedListNode <T> head;
    DoubleLinkedListNode <T> tail;
    int size;
    
    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DoubleLinkedListNode<T> getHead() {
        return head;
    }

    public void setHead(DoubleLinkedListNode<T> head) {
        this.head = head;
    }

    public DoubleLinkedListNode<T> getTail() {
        return tail;
    }

    public void setTail(DoubleLinkedListNode<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public DoubleLinkedListNode getFirst() {
        if (this.head == null) {
            return null;
        }
        else{
            return this.head;
        }
    }
    
    public DoubleLinkedListNode<T> getLastNode() {
        return this.tail;
    }
    
    public DoubleLinkedListNode<T> getNodeAt(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of range." + index);
        }
        
        DoubleLinkedListNode<T> currentNode = this.head;
        int currentNodePos = 0;
        
        while (currentNodePos < index) {
            currentNode = currentNode.getNext();
            currentNodePos++;
        }
        
        return currentNode;
    }
    
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    public void preAppend(T data) {
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(data);
        
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
        }
        
        this.size ++;
    }
    
    public void append(T data) {
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(data);
        
        if (this.size  == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setPrev(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        
        this.size ++;
    }
    
    public void print() {
        if (this.size == 0) {
            System.out.println("The list is empty.");
            return;
        }
        
        DoubleLinkedListNode<T> currentNode = this.head;
        System.out.print("{ ");
        while (currentNode.getNext() != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
        
        System.out.println(currentNode.getData() + "} ");
        System.out.println();
    }
    
    public void delete(DoubleLinkedListNode<T> deleteNode) {
        if (deleteNode == null || this.head == null) {
            return;
        }
        if (this.head == deleteNode) {
            this.head = this.head.next;
            if (this.head != null) {
                this.head.prev = null;
            }
            return;
        }
        DoubleLinkedListNode<T> currentNode = this.head;
        while (currentNode != null && currentNode != deleteNode) {
            currentNode = currentNode.next;
        }
        if (currentNode == deleteNode) {
            DoubleLinkedListNode <T> prevNode = currentNode.prev;
            DoubleLinkedListNode <T> nextNode = currentNode.next;
            if (prevNode != null) {
                prevNode.next = nextNode;
            }
            if (nextNode != null) {
                nextNode.prev = prevNode;
            }
        }
    }
    
    public void insert(T data, int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index out of range." + index);
        }
        
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(data);
        
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else if (index == 0) {
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
        } else if (index == this.size) {
            newNode.setPrev(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        } else {
            DoubleLinkedListNode<T> currentNode = this.head;
            int currentNodePos = 0;
            
            while (currentNodePos < index - 1) {
                currentNode = currentNode.getNext();
                currentNodePos++;
            }
            
            newNode.setPrev(currentNode);
            newNode.setNext(currentNode.getNext());
            currentNode.getNext().setPrev(newNode);
            currentNode.setNext(newNode);
        }
        
        this.size ++;
    }
    
    public DoubleLinkedListNode<T> search(T data) {
        DoubleLinkedListNode<T> currentNode = this.head;
        
        while(currentNode != null){
            if(currentNode.data.equals(data)){
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }
    
}
