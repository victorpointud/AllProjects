
package stack;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author victorpointud
 */

public class Stack <T> {
    StackNode<T> head;
    int size;

    public Stack() {
        this.head = null;
        this.size = 0;
    }

    public StackNode<T> getHead() {
        return head;
    }

    public void setHead(StackNode<T> head) {
        this.head = head;
    }

    public StackNode<T> getTop() {
        return head;
    }

    public void setTop(StackNode<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return head == null;
    }
    
    public T headNode() {
        return this.head.getData();
    }
    
    public void print() {
    if (isEmpty()) {
        System.out.println("The stack is empty.\n");
        return;
    }
    StackNode<T> current = this.head;
    System.out.print("{ ");
    while (current != null) {
        System.out.print(current.getData() + " ");
        current = current.getNext();
    }
    System.out.println("}\n ");
}
    
    public StackNode<T> searchNode(T data) {
        StackNode<T> current = this.head;

        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    public void add(T data) {
        StackNode<T> newNode = new StackNode<T>(data);
        newNode.setNext(this.head);
        this.head = newNode;
        this.size++;
    }
    
    public void addAt(int index, T data) {
        if (index >= size) {
            add(data);
            return;
        }

        StackNode<T> newNode = new StackNode<T>(data);
        StackNode<T> currentNode = head;
        StackNode<T> prevNode = null;
        int i = 0;
        while (i < index) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            i++;
        }
        if (prevNode == null) {
            this.head = newNode;
        } else {
            prevNode.setNext(newNode);
        }
        newNode.setNext(currentNode);
        this.size++;
    }

    public void delete(StackNode<T> node) {
        StackNode <T> currentNode = this.head;
        StackNode <T> prevNode = null;
        
        while (currentNode != null && currentNode != node) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            return;
        }
        if (prevNode == null) {
            this.head = currentNode.getNext();
        } else {
            prevNode.setNext(currentNode.getNext());
        }
        this.size--;
    }

    public T deleteFirst() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
        }
        T head = this.head.getData();
        this.head = this.head.getNext();
        this.size--;
        return head;
    }
    
    public T deleteAt(int index) {
        if (index < 0 || index >= this.size) {
            System.out.println("Index out of range.");
        }
        T data;
        if (index == 0) {
            data = this.head.getData();
            this.head = this.head.getNext();
        } else {
            StackNode<T> prevNode = head;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.getNext();
            }
            StackNode<T> currentNode = prevNode.getNext();
            data = currentNode.getData();
            prevNode.setNext(currentNode.getNext());
        }
        this.size--;
        return data;
    }

    public void deleteDuplicated() {
        if (this.size <= 1) {
            return; 
        }

        Set<T> info = new HashSet<T>();
        StackNode<T> curremtNode = head;
        StackNode<T> prevNode = null;
        while (curremtNode != null) {
            if (info.contains(curremtNode.getData())) {
                prevNode.setNext(curremtNode.getNext());
                curremtNode = curremtNode.getNext();
                this.size--;
            } else {
                info.add(curremtNode.getData());
                prevNode = curremtNode;
                curremtNode = curremtNode.getNext();
            }
        }
    }
    
    public void report (Stack stack1, Stack stack2){        
        if (stack1.isEmpty() || stack2.isEmpty()){
            System.out.println("The stacks doesnt have elements.\n");
        }
        else if (stack1.equalElements(stack2)){
            System.out.println("The stacks are the same.\n");
        }
        else if (stack1.size == stack2.size){
            System.out.println("The stacks have the same size but not the same elements.\n");
        }
        else {
            System.out.println("The stacks arent the same.\n");
        }
    }
    
    public boolean equalElements(Stack list2) {
        StackNode pointer = this.head;
        StackNode pointer2 = list2.head;
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
        
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.head.getData();
    }
    
    public void mayToMinSort(){
        if (this.isEmpty()) {
            System.out.println("The stack is empty.\n");
            return;
        }
        Stack <T> tempStack = new Stack();
        while (!this.isEmpty()) {
            T currentData = this.deleteFirst();
            while (!tempStack.isEmpty() && (int)tempStack.peek() > (int)currentData) {
                this.add(tempStack.deleteFirst());
            }
            tempStack.add(currentData);
        }
        while (!tempStack.isEmpty()) {
            T currentData = tempStack.deleteFirst();
            this.add(currentData);
            System.out.print("{ " + currentData + " } ");
        }
        System.out.println("");
        System.out.println("");
    }
    
    public void minToMaySort(){
        if (this.isEmpty()) {
            System.out.println("The stack is empty.\n");
            return;
        }
        Stack <T> tempStack = new Stack();
        while (!this.isEmpty()) {
            T currentData = this.deleteFirst();
            while (!tempStack.isEmpty() && (int)tempStack.peek() < (int)currentData) {
                this.add(tempStack.deleteFirst());
            }
            tempStack.add(currentData);
        }
        while (!tempStack.isEmpty()) {
            T currentData = tempStack.deleteFirst();
            this.add(currentData);
            System.out.print("{ " + currentData + " } ");
        }
        System.out.println("");
        System.out.println("");
    }

    public void normalReverse() {
        StackNode previous = null;
        StackNode current = this.head;
        while (current != null) {
            StackNode nextNode = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextNode;
        }
        this.head = previous;
    }

    public boolean compareStacks(StackNode <T> head1, StackNode <T> head2) {
        StackNode <T> temp1 = head1;
        StackNode <T> temp2 = head2;
        do {
            if (temp1.getData().equals(temp2.getData())) {
                temp1 = temp1.getNext();
                temp2 = temp2.getNext();
            } else {
                return false;
            }
        } while (temp1 != head1 && temp2 != head2);
        return temp1 == head1 && temp2 == head2;
    }
    
    public void checkIfPalindrome() {
        if (this.head == null) {
            System.out.println("The stack is empty.\n");
            return;
        }
        StackNode slow = this.head;
        StackNode fast = this.head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        StackNode secondHalf = slow.getNext();
        secondHalf = nodeReverse(secondHalf);
        StackNode firstHalf = this.head;
        while (secondHalf != null) {
            if (firstHalf.getData() != secondHalf.getData()) {
                System.out.println("The stack is not a palindrome.\n");
                return;
        }
        firstHalf = firstHalf.getNext();
        secondHalf = secondHalf.getNext();
        }
        System.out.println("The stack is a palindrome.\n");
    }
    
    public StackNode nodeReverse(StackNode head) {
        StackNode previous = null;
        StackNode current = head;
        while (current != null) {
            StackNode nextNode = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextNode;
        }
        return previous;
    }
}
