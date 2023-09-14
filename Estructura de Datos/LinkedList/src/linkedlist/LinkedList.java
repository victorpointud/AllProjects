
package linkedlist;

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
    
    public LinkedListNode <T> searchNode( T data) {
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
    
    public LinkedListNode <T> getNodeAt(int pos){
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
    
    public void print() {
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
        if (pos < 0 || pos > this.size) {
            System.out.println("Out of range.\n");;
        }
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

    public void delete(T value) {
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
    
    public void report (LinkedList list1, LinkedList list2){        
        if (list1.isEmpty() || list2.isEmpty()){
            System.out.println("The lists doesnt have elements.\n");
        }
        else if (list1.equalElements(list2)){
            System.out.println("The lists are the same.\n");
        }
        else if (list1.size == list2.size){
            System.out.println("The lists have the same size but not the same elements.\n");
        }
        else {
            System.out.println("The lists arent the same.\n");
        }
    }
    
    public boolean equalElements(LinkedList list2) {
        LinkedListNode pointer = this.head;
        LinkedListNode pointer2 = list2.getHead();
        while (pointer != null && pointer2 != null) {
            if (pointer.data == pointer2.data) {
                pointer = pointer.next;
                pointer2 = pointer2.next;
            } else {
                return false;
            }
        }
        return pointer == null && pointer2 == null;
    }

    public void minToMaySort(){
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
    
    public void mayToMinSort(){
        LinkedList linkedlist = new LinkedList();
        while(this.head != null){
            LinkedListNode pointer = this.head;
            LinkedListNode prevMax = null;
            LinkedListNode max = pointer;
            while (pointer.next != null){
                int ja = (int) pointer.next.data;
                int ja2 = (int) max.data;
                if(ja > ja2){
                prevMax = pointer;
                max = pointer.next;
                }
                pointer = pointer.next;
            }
            if(prevMax != null){
                prevMax.setNext(max.next);
            }
            else{
                this.setHead(max.next);
            }
            LinkedListNode aux = new LinkedListNode(max.data);
            linkedlist.addLast(aux.data);
            linkedlist.addFirst(aux);
            System.out.print("{ "  + aux.data + " } ");
        
        }
        System.out.println("");
        System.out.println("");
    } 
        
    public void normalReverse() {
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
    
    public boolean compareLists(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode temp1 = head1;
        LinkedListNode temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.getData() == temp2.getData()) {
                temp1 = temp1.getNext();
                temp2 = temp2.getNext();
            } else {
                return false;
            }
        }
        if (temp1 == null && temp2 == null) {
            return true;
        }
        return false;
    }

    public void checkIfPalindrome() {
        if (this.head == null) {
            System.out.println("The list is empty.\n");
            return;
        }
        LinkedListNode slow = this.head;
        LinkedListNode fast = this.head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        LinkedListNode secondHalf = slow.getNext();
        secondHalf = nodeReverse(secondHalf);
        LinkedListNode firstHalf = this.head;
        while (secondHalf != null) {
            if (firstHalf.getData() != secondHalf.getData()) {
                System.out.println("The list is not a palindrome.\n");
                return;
        }
        firstHalf = firstHalf.getNext();
        secondHalf = secondHalf.getNext();
        }
        System.out.println("The list is a palindrome.\n");
        }
    
    public LinkedListNode nodeReverse(LinkedListNode head) {
        LinkedListNode previous = null;
        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode nextNode = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextNode;
        }
        return previous;
    }

    public boolean haveCicle() {
        if (isEmpty() || this.head.next == null) {
            System.out.println("La lista está vacía o tiene solo un elemento, no hay ciclo");
            return false;  
        }
        LinkedListNode slow = this.head;
        LinkedListNode fast = this.head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                System.out.println("A cicle has been found.");
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("No hay ciclo.");
        return false;
    }
    
}