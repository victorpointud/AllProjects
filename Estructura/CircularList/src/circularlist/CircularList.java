
package circularlist;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author victorpointud
 */

public class CircularList<T> {
    CircularListNode <T> head;
    CircularListNode <T> tail;
    int size;

    public CircularList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public CircularListNode<T> getHead() {
        return head;
    }

    public void setHead(CircularListNode<T> head) {
        this.head = head;
    }

    public CircularListNode<T> getTail() {
        return tail;
    }

    public void setTail(CircularListNode<T> tail) {
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
    
    public CircularListNode <T> searchNode(T data) {
        if (this.head == null) {
            return null;
        }
        CircularListNode<T> currentNode = this.head;
        do {
            if (currentNode.data.equals(data)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        } while (currentNode != this.head);
        return null;
    }

    public void print() {
        if (this.head == null || (this.head == this.tail && this.head == null)) {
            System.out.println("The list is empty.\n");
            return;
        }
        CircularListNode<T> currentNode = this.head;
        System.out.print("{ ");
        do {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        } while (currentNode != this.head);
        System.out.println("} \n");
    }

    public void add(T value) {
        CircularListNode <T> newNode = new CircularListNode <T>(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } 
        else {
            this.tail.next = newNode;
            newNode.next = this.head;
            this.tail = newNode;
        }
    }
    
    public void addFirst(T data) {
        CircularListNode <T> newNode = new CircularListNode <T>(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.next = this.head;
        } else {
            newNode.next = this.head;
            this.head = newNode;
            this.tail.next = this.head;
        }
        this.size++;
    }

    public void addLast(T data) {
        CircularListNode <T> newNode = new CircularListNode <T>(data);
        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.next = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
            this.tail.next = this.head;
        }
        this.size++;
    }

    public void addAt(T data, int index) {
    CircularListNode <T> newNode = new CircularListNode <T>(data);
    if (this.size == 0) {
        this.head = newNode;
        this.tail = newNode;
        newNode.setNext(newNode);
        newNode.setPrev(newNode);
    } else if (index == 0) {
        newNode.setNext(this.head);
        newNode.setPrev(this.tail);
        this.head.setPrev(newNode);
        this.tail.setNext(newNode);
        this.head = newNode;
    } else if (index == this.size) {
        newNode.setNext(this.head);
        newNode.setPrev(this.tail);
        this.tail.setNext(newNode);
        this.head.setPrev(newNode);
        this.tail = newNode;
    } else {
        CircularListNode <T> currentNode = this.head;
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
    this.size++;
}

    public void delete(T data) {
        if (this.head == null) {
            return;
        }
        CircularListNode<T> currentNode = this.head;
        CircularListNode<T> prevNode = this.tail;
        do {
            if (currentNode.data.equals(data)) {
                if (this.head == this.tail) {
                    this.head = null;
                    this.tail = null;
                } else if (currentNode == this.head) {
                    this.head = this.head.next;
                    this.tail.next = this.head;
                } else if (currentNode == this.tail) {
                    this.tail = prevNode;
                    this.tail.next = this.head;
                } else {
                    prevNode.next = currentNode.next;
                }
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        } while (currentNode != this.head);
    }
    
    public void deleteFirst() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        this.head = this.head.next;
        this.tail.next = this.head;
        this.size--;
    }
    
    public void deleteLast() {
        if (this.head == null) {
            return;
        }
        if (this.head == null) {
            return;
        }
        CircularListNode<T> currentNode = this.head;
        while (currentNode.next != this.head) {
            currentNode = currentNode.next;
        }

        if (currentNode == this.head) {
            this.head = null;
        } else {
            CircularListNode<T> prevNode = this.head;

            while (prevNode.next != currentNode) {
                prevNode = prevNode.next;
            }
            prevNode.next = this.head;
        }
    }
    
    public void deleteAt(int index) {
        if (this.head == null) {
            return;
        }
        CircularListNode<T> currentNode = this.head;
        CircularListNode<T> prevNode = null;
        int contador = 0;
        while (contador < index && currentNode.next != this.head) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            contador++;
        }
        if (contador == index) {
            if (currentNode == this.head) {
                this.head = currentNode.next;
            }
            if (prevNode != null) {
                prevNode.next = currentNode.next;
            }
            currentNode = null;
        }
    }

    public void deleteDuplicated() {
        if (this.head == null) {
            return;
        }
        Set<T> info = new HashSet<>();
        info.add(this.head.data);
        CircularListNode<T> currentNode = this.head.next;
        CircularListNode<T> prevNode = this.head;
        while (currentNode != this.head) {
            if (info.contains(currentNode.data)) {
                prevNode.next = currentNode.next;
                currentNode = currentNode.next;
            } else {
                info.add(currentNode.data);;
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
    }
    
    public void report(CircularList list1, CircularList list2) {
        if (list1.isEmpty() || list2.isEmpty() || list1.tail == null || list2.tail == null) {
            System.out.println("The list doesn't have elements.\n");
        } else {
            CircularListNode currentNode1 = list1.head;
            boolean areEqual = false;
            do {
                CircularListNode currentNode2 = list2.head;
                do {
                    if (currentNode1.getData().equals(currentNode2.getData())) {
                        CircularListNode current1 = currentNode1;
                        CircularListNode current2 = currentNode2;
                        boolean areEqualFromHere = true;
                        do {
                            current1 = current1.getNext();
                            current2 = current2.getNext();
                            if (!current1.getData().equals(current2.getData())) {
                                areEqualFromHere = false;
                                break;
                            }
                        } while (current1 != currentNode1 && current2 != currentNode2);

                        if (areEqualFromHere) {
                            areEqual = true;
                            break;
                        }
                    }
                    currentNode2 = currentNode2.getNext();
                } while (currentNode2 != list2.head);
                currentNode1 = currentNode1.getNext();
            } while (currentNode1 != list1.head);
            if (areEqual) {
                System.out.println("The lists are the same.\n");
            } else if (list1.size == list2.size) {
                System.out.println("The lists have the same size but not the same elements.\n");
            } else {
                System.out.println("The lists aren't the same.\n");
            }
        }
    }

    public boolean equalElements(CircularList list2) {
        CircularListNode pointer = this.getTail();
        boolean isEqual = false;
        while(pointer.getNext()!= this.getTail()){
            CircularListNode pointer2 = list2.getTail();
            while(pointer2.getNext() != list2.getTail()){
                if(pointer.getData().equals(pointer2.getData())){
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

    public void sort(){
        if (this.head == null || (this.head == this.tail && this.head == null)) {
            System.out.println("The list is empty.\n");
            return;
        }
        CircularListNode<T> aux;
        while (this.head != this.tail) {
            CircularListNode<T> pointer = this.head;
            CircularListNode<T> prevMin = null;
            CircularListNode<T> min = pointer;
            while (pointer.getNext() != this.head) {
                int ja = (int) pointer.getNext().getData();
                int ja2 = (int) min.getData();
                if (ja < ja2) {
                    prevMin = pointer;
                    min = pointer.getNext();
                }
                pointer = pointer.getNext();
            }
            if (prevMin != null) {
                prevMin.setNext(min.getNext());
            } else {
                this.head = min.getNext();
            }
            aux = new CircularListNode(min.getData());
            aux.setNext(min.getNext());
            aux.setPrev(min.getPrev());
            min.getPrev().setNext(aux);
            min.getNext().setPrev(aux);
            if (this.head == min) {
                this.head = min.getNext();
            }
            System.out.print("{ "  + aux.getData() + " } ");
        }
        this.tail = this.head.getPrev();
        System.out.println("");
        System.out.println("");
    }

    public void normalReverse() {
        if (this.head == null || (this.head == this.tail && this.head == null)) {
            System.out.println("The list is empty.\n");
            return;
        }
        CircularListNode<T> previous = this.tail;
        CircularListNode<T> current = this.head;
        while (current != this.head) {
            CircularListNode<T> nextNode = current.getNext();
            current.setNext(previous);
            current.setPrev(nextNode);
            previous = current;
            current = nextNode;
        }
        this.head = previous;
        this.tail = this.tail.getPrev();
    }

    public boolean compareLists(CircularListNode head1, CircularListNode head2) {
        CircularListNode temp1 = head1;
        CircularListNode temp2 = head2;
        do {
            if (temp1.getData() == temp2.getData()) {
                temp1 = temp1.getNext();
                temp2 = temp2.getNext();
            } 
            else {
                return false;
            }
        } 
        while (temp1 != head1 && temp2 != head2);
            if (temp1 == head1 && temp2 == head2) {
                return true;
            } 
            else {
                return false;
            }
    }

    public void checkIfPalindrome() {
        if (this.head == null || (this.head == this.tail && this.head == null)) {
            System.out.println("The list is empty.\n");
            return;
        }
        CircularListNode slow = this.head;
        CircularListNode fast = this.head;
        while (fast != this.tail && fast.getNext() != this.tail) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        if (fast == this.tail) { 
            slow = slow.getNext();
        }
        CircularListNode secondHalf = nodeReverse(slow);
        CircularListNode firstHalf = this.head;
        while (secondHalf != this.head) {
            if (firstHalf != secondHalf) {
                System.out.println("The list is not a palindrome.\n");
                return;
            }
            firstHalf = firstHalf.getNext();
            secondHalf = secondHalf.getNext();
        }
        System.out.println("The list is a palindrome.\n");
    }

    public CircularListNode nodeReverse(CircularListNode node) {
        if (node == null) {
            return null;
        }
        CircularListNode prev = null;
        CircularListNode current = node;
        CircularListNode next = null;
        do {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        } 
        while (current != node);
        node.setNext(prev);
        return prev;
    }

}