
package proyectoamazon;

import javax.swing.JOptionPane;

/**
 *
 * @author luisarismendi
 */

public class ListProducts {
    private NodeProduct head;
    private int length;

    public ListProducts (NodeProduct head) {
        this.head = head;
        if (head != null) {
            this.length = 1;
        } else {
            this.length = 0;
        }       
    }

    public void setHead(NodeProduct head) {
        this.head = head;
    }

    public NodeProduct getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }
    
    public void insertStart(Product element){
        NodeProduct node = new NodeProduct(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            node.setNext(getHead());
            setHead(node);
        }
        length++;
    }
    
    public void insertEnd(Product element) {
        NodeProduct node = new NodeProduct(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            NodeProduct pointer = getHead();
            while (pointer.getNext() != null) {
               pointer = pointer.getNext();
            }
        pointer.setNext(node);
        }
        length++;
        }
        
    public boolean isEmpty() {
        return getHead() == null;
    }
    
        public String printList() {
        NodeProduct pointer = getHead();
        String result = "";
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null,"La lista esta vacia");
            return result;
        } else {
        while (pointer != null) {
            result += pointer.getElement().name + ", " + pointer.getElement().quantitiy + "\n";
            pointer = pointer.getNext();
        }
        result += "\n";
        }
        return result;
    }
    
    public void deleteFirst() {
        NodeProduct pointer = getHead();
        if (!isEmpty()) {
            setHead(pointer.getNext());
            pointer.setNext(null);
        }
    length--;
    }
    
    public void deleteLast() {
        NodeProduct pointer = getHead();
        if (!isEmpty()) {
            while (pointer.getNext().getNext() != null) {
                pointer = pointer.getNext();
            }
        pointer.setNext(null);
        }
    length--;
    }
    
    public void AddProduct (NodeProduct pointerResult) {
        NodeProduct pointer = getHead();
        boolean isInList = false;
        while (pointer != null) {
            if (pointer.getElement().getName().equals(pointerResult.getElement().getName())) {
                isInList = true;
            }
            pointer = pointer.getNext();
        }
        pointer = getHead();
        if (isInList) {
            while (pointer != null) {
                if (pointer.getElement().getName().equals(pointerResult.getElement().getName())) {
                   pointer.getElement().setQuantitiy(pointer.getElement().getQuantitiy() + pointerResult.getElement().getQuantitiy());
            }
                pointer = pointer.getNext();
        }
        } else {
            insertEnd(pointerResult.getElement());
        }
    
}
    public Product GetProductByName (String name) {
        NodeProduct pointer = getHead();
        while (pointer != null) {
            if (pointer.getElement().getName().equals(name)) {
                return pointer.getElement();
            }
            pointer = pointer.getNext();
        }
        return null;
    }
    
    public boolean ProductIsAvailable (String name, int quantity) {
        NodeProduct pointer = getHead();
        while (pointer != null) {
            if (pointer.getElement().getName().equals(name) && pointer.getElement().getQuantitiy() >= quantity) {
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }
    
    public boolean ProductIsIn (String name) {
        NodeProduct pointer = getHead();
        while (pointer != null) {
            if (pointer.getElement().getName().equals(name)) {
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }
}
