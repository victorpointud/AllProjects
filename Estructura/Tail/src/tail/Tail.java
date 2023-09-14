package tail;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author victorpointud
 */

public class Tail <T> {

    TailNode <T> head;
    TailNode <T> last;
    int size;

    public Tail() {
      this.head = null;
      this.last = null;
      this.size = 0;
    }

    public TailNode<T> getHead() {
        return head;
    }

    public void setHead(TailNode<T> head) {
        this.head = head;
    }

    public TailNode<T> getLast() {
        return last;
    }

    public void setLast(TailNode<T> last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public T firstNode() {
      if (isEmpty()) {
        throw new IllegalStateException("The tail is empty.");
      }
      return this.head.getData();
    }
    
    public TailNode<T> searchNode(T searchData) {
        TailNode<T> currentNode = this.head;
        while (currentNode != null) {
          if (currentNode.getData().equals(searchData)) {
            return currentNode;
          }
          currentNode = currentNode.getNext();
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }
    
    public void print() {
        TailNode<T> currentNode = this.head;
        System.out.print("{ ");
        while (currentNode != null) {
          System.out.print(currentNode.getData() + " ");
          currentNode = currentNode.getNext();
        }
        System.out.println("} \n");
    }

    public void add(T data) {
      TailNode <T> newNode = new TailNode <T> (data);
      if (isEmpty()) {
        this.head = newNode;
        this.last = newNode;
      } else {
        this.last.setNext(newNode);
        this.last = newNode;
      }
    }
    
    public void addAt(T data, int index) {
        
        TailNode<T> newNode = new TailNode<T>(data);
        if (index == 0) {
          newNode.setNext(this.head);
          this.head = newNode;
          if (this.last == null) {
            this.last = this.head;
          }
        } else {
          TailNode<T> nodoActual = this.head;
          for (int i = 0; i < index - 1; i++) {
            nodoActual = nodoActual.getNext();
          }
          newNode.setNext(nodoActual.getNext());
          nodoActual.setNext(newNode);
          if (newNode.getNext() == null) {
            this.last = newNode;
          }
        }
      }

    public void delete(T searchData) {
        if (this.head == null) {
          return;
        }
        if (this.head.getData().equals(searchData)) {
          this.head = this.head.getNext();
          if (this.head == null) {
            this.last = null;
          }
          return;
        }
        TailNode<T> prevNode = this.head;
        TailNode<T> currentNode = this.head.getNext();
        while (currentNode != null) {
          if (currentNode.getData().equals(searchData)) {
            prevNode.setNext(currentNode.getNext());
            if (prevNode.getNext() == null) {
              this.last = prevNode;
            }
            return;
          }
          prevNode = currentNode;
          currentNode = currentNode.getNext();
        }
      }
     
    public T deleteFirst() {
      if (isEmpty()) {
        throw new IllegalStateException("The tail is empty.");
      }
      T headData = this.head.getData();
      this.head = this.head.getNext();
      if (this.head == null) {
        this.last = null;
      }
      return headData;
    }
    
    public void deleteLast() {
        if (this.head == null) {
          return;
        }
        if (this.head.getNext() == null) {
          this.head = null;
          this.last = null;
          return;
        }
        TailNode<T> prevNode = this.head;
        TailNode<T> currentNode = this.head.getNext();
        while (currentNode.getNext() != null) {
          prevNode = currentNode;
          currentNode = currentNode.getNext();
        }
        prevNode.setNext(null);
        this.last = prevNode;
      }

    public void deleteAt(int index) {
        if (this.head == null) {
          return;
        }
        if (index == 0) {
          this.head = this.head.getNext();
          if (this.head == null) {
            this.last = null;
          }
          return;
        }
        TailNode <T> prevNode = null;
        TailNode <T> currentNode = this.head;
        int counter = 0;
        while (counter < index && currentNode != null) {
          prevNode = currentNode;
          currentNode = currentNode.getNext();
          counter++;
        }
        if (currentNode != null) {
          prevNode.setNext(currentNode.getNext());
          if (prevNode.getNext() == null) {
            this.last = prevNode;
          }
        }
      }

    public void deleteDuplicated() {
        if (this.head == null) {
          return;
        }
        Set<T> valores = new HashSet<>();
        valores.add(this.head.getData());
        TailNode<T> prevNode = this.head;
        TailNode<T> currentNode = this.head.getNext();
        while (currentNode != null) {
          if (valores.contains(currentNode.getData())) {
            prevNode.setNext(currentNode.getNext());
            if (prevNode.getNext() == null) {
              this.last = prevNode;
            }
          } else {
            valores.add(currentNode.getData());
            prevNode = currentNode;
          }
          currentNode = currentNode.getNext();
        }
      }

    public void report (Tail tail1, Tail tail2){        
        if (tail1.isEmpty() || tail2.isEmpty()){
            System.out.println("The tails doesnt have elements.\n");
        }
        else if (tail1.equalElements(tail2)){
            System.out.println("The tails are the same.\n");
        }
        else if (tail1.size == tail2.size){
            System.out.println("The tails have the same size but not the same elements.\n");
        }
        else {
            System.out.println("The tails arent the same.\n");
        }
    }

    public boolean equalElements(Tail tail) {
        TailNode pointer = this.head;
        TailNode pointer2 = tail.head;
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
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return null;
        }
        return head.data;
    }
    
    public void minToMaySort() {
        if (this.isEmpty()) {
            System.out.println("The queue is empty.\n");
            return;
        }
        Tail <T> tail = new Tail();
        while (!this.isEmpty()) {
            T currentData = this.deleteFirst();
            while (!tail.isEmpty() && (int) tail.peek() > (int) currentData) {
                this.add(tail.deleteFirst());
            }
            tail.add(currentData);
        }
        while (!tail.isEmpty()) {
            T currentData = tail.deleteFirst();
            this.add(currentData);
            System.out.print("{ " + currentData + " } ");
        }
        System.out.println("");
        System.out.println("");
    }

    public void mayToMinSort() {
        if (this.isEmpty()) {
            System.out.println("The queue is empty.\n");
            return;
        }
        Tail <T> tail = new Tail();
        while (!this.isEmpty()) {
            T currentData = this.deleteFirst();
            while (!tail.isEmpty() && (int) tail.peek() < (int) currentData) {
                this.add(tail.deleteFirst());
            }
            tail.add(currentData);
        }
        while (!tail.isEmpty()) {
            T currentData = tail.deleteFirst();
            this.add(currentData);
            System.out.print("{ " + currentData + " } ");
        }
        System.out.println("");
        System.out.println("");
    }

    public void normalReverse() {
        TailNode previous = null;
        TailNode current = this.head;
        while (current != null) {
            TailNode nextNode = current.getNext();
            current.setNext(previous);
            current.setPrev(nextNode); // Agregar este paso para manejar el puntero previo
            previous = current;
            current = nextNode;
        }
        this.head = previous;
    }

    public boolean compareQueues(TailNode <T> front1, TailNode <T> front2) {
        TailNode <T> temp1 = front1;
        TailNode <T> temp2 = front2;
        do {
            if (temp1.getData().equals(temp2.getData())) {
                temp1 = temp1.getNext();
                temp2 = temp2.getNext();
            } else {
                return false;
            }
        } while (temp1 != null && temp2 != null);
        return temp1 == null && temp2 == null;
    }

    public void checkIfPalindrome() {
        if (this.head == null) {
            System.out.println("The tail is empty.\n");
            return;
        }
        TailNode slow = this.head;
        TailNode fast = this.head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        TailNode secondHalf = slow.getNext();
        secondHalf = nodeReverse(secondHalf);
        TailNode firstHalf = this.head;
        while (secondHalf != null) {
            if (firstHalf.getData() != secondHalf.getData()) {
                System.out.println("The tail is not a palindrome.\n");
                return;
            }
            firstHalf = firstHalf.getNext();
            secondHalf = secondHalf.getNext();
        }
        System.out.println("The tail is a palindrome.\n");
    }

    public TailNode <T> nodeReverse(TailNode<T> head) {
        TailNode <T> previous = null;
        TailNode <T> current = head;
        while (current != null) {
            TailNode <T> nextNode = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextNode;
        }
        return previous;
    }

}
