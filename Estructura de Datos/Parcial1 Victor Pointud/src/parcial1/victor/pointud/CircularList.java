
package parcial1.victor.pointud;


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
    
}

