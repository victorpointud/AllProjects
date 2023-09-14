
package binarytree;

/**
 *
 * @author victorpointud
 */

import java.util.HashSet;

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
    
    public void addAt(T data, int pos){
        
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode pointer = this.head;
        int cont = 1;
                
        if(this.head == null){
               
            this.head = newNode;
            this.size ++;
                
        }else if (pos == 0){
            
            newNode.next = this.head;
            this.head = newNode;
            this.size ++;
            
        }else if(pos >= this.size){
            
            this.getLast().next = newNode;
            this.size ++;
            
        }else{
            
            while(pointer.next != null){
                
                if(cont == pos){
                    
                    newNode.next = pointer.next;
                    pointer.next = newNode;
                }
                
                pointer = pointer.next;
                cont++;
            }
            this.size ++;
        }
        
    }
        
    public void deleteFirst() {
        if (this.head == null) {
            return;
        }
        this.head = this.head.next;
    }
    
    public void deleteLast() {
        if (this.head == null) {
            return;
        }
        if (this.head.next == null) {
            this.head = null;
            return;
        }
        LinkedListNode secondLast = this.head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }
    
    public void deleteAt(int pos) {
        LinkedListNode current = this.head;
        LinkedListNode previous = null;
        int currentPos = 0;
        while (current != null && currentPos != pos) {
            previous = current;
            current = current.getNext();
            currentPos++;
        }
        if (current != null) {
            if (previous == null) {
                this.head = current.getNext();
            } 
            else {
                previous.setNext(current.getNext());
            }
        }
    }

    
    public void deleteNode(T value) {
        LinkedListNode current = this.head;
        LinkedListNode previous = null;
        while (current != null && current.data != value) {
            previous = current;
            current = current.next;
        }
        if (current != null) {
            if (previous == null) {
                head = current.next;
            } else {
                previous.setNext(current.next);
            }
        }
    }

    
    public void deleteDuplicated(){
        HashSet<T> set = new HashSet<T>();
        LinkedListNode<T> prevNode = null;
        LinkedListNode<T> currentNode = head;
        
        while (currentNode != null) {
            if (!set.add(currentNode.data)) {
                prevNode.next = currentNode.next;
            } else {
                prevNode = currentNode;
            }
            currentNode = currentNode.next;
        }

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
    
    public void reverse() {
        LinkedListNode previous = null;
        LinkedListNode current = this.head;
        while (current != null) {
            LinkedListNode nextNode = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextNode;
        }
        this.head = previous;
    }

    
}