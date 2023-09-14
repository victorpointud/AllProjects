
package doublelinkedlist;

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
    
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    public DoubleLinkedListNode<T> searchNode(T data) {
        DoubleLinkedListNode<T> currentNode = this.head;
        
        while(currentNode != null){
            if(currentNode.data.equals(data)){
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
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

    public void print() {
        if (this.size == 0) {
            System.out.println("The list is empty.\n");
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
    
    public void add(T data) {
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(data);
        if (this.head == null) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }
    
    public void addFirst(T data) {
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
    
    public void addLast(T data) {
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

    public void addAt(T data, int index) {
        if (index < 0 || index > this.size) {
            System.out.println("Out of range.\n");;
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

    public void deleteFirst() {
        if (this.size == 0) {
            System.out.println("The list is empty.");
        }
        
        else if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            DoubleLinkedListNode<T> currentNode = this.head.getNext();
            currentNode.setPrev(null);
            this.head = currentNode;
        }
        
        this.size--;
    }
    
    public void deleteLast() {
        if (this.size == 0) {
            System.out.println("The list is empty.");
        }
        
        else if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            DoubleLinkedListNode<T> currentNode = this.tail.getPrev();
            currentNode.setNext(null);
            this.tail = currentNode;
        }
        
        this.size--;
    }
    
    public void deleteAt(int index) {
        if (index == 1) {
            this.head = this.head.next;
            if (this.head != null) {
                this.head.prev = null;
            } else {
                this.tail = null;
            }
        } else if (index == size) {
            this.tail = this.tail.prev;
            this.tail.next = null;
        } else {
            DoubleLinkedListNode<T> currentNode = this.head;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.next;
            }
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }
        this.size--;
    }
    
    public void deleteDuplicated() {
        if (this.size == 0) {
            System.out.println("The list is empty.");
        }
        
        DoubleLinkedListNode<T> currentNode = this.head;
        DoubleLinkedListNode<T> runner = null;
        
        while (currentNode != null && currentNode.getNext() != null) {
            runner = currentNode;
            
            while (runner.getNext() != null) {
                if (currentNode.getData().equals(runner.getNext().getData())) {
                    runner.setNext(runner.getNext().getNext());
                    if (runner.getNext() != null) {
                        runner.getNext().setPrev(runner);
                    } else {
                        this.tail = runner;
                    }
                    this.size--;
                } else {
                    runner = runner.getNext();
                }
            }
            
            currentNode = currentNode.getNext();
        }
    }
    
    public void report (DoubleLinkedList list1, DoubleLinkedList list2){        
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

    public boolean equalElements(DoubleLinkedList list2) {
        
       DoubleLinkedListNode pointer = this.getHead();
       boolean isEqual = false;
       
       while(pointer.getNext()!= null){
           DoubleLinkedListNode pointer2 = list2.getHead();
           while(pointer2.getNext() != null){
               if(pointer.getData() == pointer2.getData()){
                    isEqual = true;
               }
               else{
                   isEqual = false;
               }
               pointer2 = pointer2.getNext();
           }
          pointer = pointer.getNext();
       }
        return isEqual;
    }
    
    public void minToMaySort(){
        DoubleLinkedList linkedlist = new DoubleLinkedList();
        while(this.head != null){
            DoubleLinkedListNode pointer = this.head;
            DoubleLinkedListNode prevMin = null;
            DoubleLinkedListNode min = pointer;
            while (pointer.getNext() != null){
                int ja = (int) pointer.getNext().getData();
                int ja2 = (int) min.getData();

                if(ja < ja2){
                    prevMin = pointer;
                    min = pointer.getNext();
                }
                pointer = pointer.getNext();;

            }
            if(prevMin != null){
                prevMin.setNext(min.getNext());
            }
            else{
                this.setHead(min.getNext());
            }
            DoubleLinkedListNode aux = new DoubleLinkedListNode(min.getData());
            linkedlist.addLast(aux);
            linkedlist.addFirst(aux);
            System.out.print("{ "  + aux.getData() + " } ");
        }
        System.out.println("");
        System.out.println("");
    }

    public void mayToMinSort() {
        DoubleLinkedList linkedlist = new DoubleLinkedList();
        while(this.head != null){
            DoubleLinkedListNode pointer = this.head;
            DoubleLinkedListNode prevMax = null;
            DoubleLinkedListNode max = pointer;
            while (pointer.getNext() != null){
                int ja = (int) pointer.getNext().getData();
                int ja2 = (int) max.getData();

                if(ja > ja2){
                    prevMax = pointer;
                    max = pointer.getNext();
                }
                pointer = pointer.getNext();
            }
            if(prevMax != null){
                prevMax.setNext(max.getNext());
            }
            else{
                this.setHead(max.getNext());
            }
            DoubleLinkedListNode aux = new DoubleLinkedListNode(max.getData());
            linkedlist.addLast(aux);
            System.out.print("{ "  + aux.getData() + " } ");
        }
        System.out.println("");
        System.out.println("");
        this.head = linkedlist.getHead();
    }

    public void normalReverse() {
        DoubleLinkedListNode previous = null;
        DoubleLinkedListNode current = this.head;
        while (current != null) {
            DoubleLinkedListNode nextNode = current.getNext();
            current.setNext(previous);
            current.setPrev(nextNode); 
            previous = current;
            current = nextNode;
        }
        this.head = previous;
    }
    
    public boolean compareLists(DoubleLinkedListNode head1, DoubleLinkedListNode head2) {
        DoubleLinkedListNode temp1 = head1;
        DoubleLinkedListNode temp2 = head2;
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
        DoubleLinkedListNode slow = this.head;
        DoubleLinkedListNode fast = this.head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        DoubleLinkedListNode secondHalf = slow.getNext();
        secondHalf = nodeReverse(secondHalf);
        DoubleLinkedListNode firstHalf = this.head;
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

    public DoubleLinkedListNode nodeReverse(DoubleLinkedListNode head) {
        DoubleLinkedListNode previous = null;
        DoubleLinkedListNode current = head;
        while (current != null) {
            DoubleLinkedListNode nextNode = current.getNext();
            current.setNext(previous);
            current.setPrev(nextNode); // se agrega el enlace previo
            previous = current;
            current = nextNode;
        }
        return previous;
    }

}
