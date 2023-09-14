
package proyectoamazon;

/**
 *
 * @author luisarismendi
 */

public class ListWarehouse {
    private NodeWarehouse head;
    private int length;

    public ListWarehouse (NodeWarehouse head) {
        this.head = head;
        if (head != null) {
            this.length = 1;
        } else {
            this.length = 0;
        }
    }

    public void setHead(NodeWarehouse head) {
        this.head = head;
    }

    public NodeWarehouse getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }
    
    public void insertStart(Warehouse element){
        NodeWarehouse node = new NodeWarehouse(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            node.setNext(getHead());
            setHead(node);
        }
        length++;
    }
    
    public void insertEnd(Warehouse element) {
        NodeWarehouse node = new NodeWarehouse(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            NodeWarehouse pointer = getHead();
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
    
    public void printList() {
        NodeWarehouse pointer = getHead();
        if (isEmpty()) {
            System.out.println("La lista esta vacia");} else {
        while (pointer.getNext() != null) {
            System.out.println(pointer.getElement());
            pointer = pointer.getNext();
        }
        System.out.println(pointer.getElement());
        }
    }
    
    public void deleteFirst() {
        NodeWarehouse pointer = getHead();
        if (!isEmpty()) {
            setHead(pointer.getNext());
            pointer.setNext(null);
        }
    length--;
    }
    
    public void deleteLast() {
        NodeWarehouse pointer = getHead();
        if (!isEmpty()) {
            while (pointer.getNext().getNext() != null) {
                pointer = pointer.getNext();
            }
        pointer.setNext(null);
        }
    length--;
    }
    
    public void createProductList () {
        NodeWarehouse pointer = getHead();
        while (pointer != null) {
            ListProducts list = pointer.getElement().listOfProducts;
            NodeProduct pointerPro = list.getHead();
            while (pointerPro != null) {
                pointerPro = pointerPro.getNext();
            }
        }
    }
    
    public ListProducts getListOfProducts() {
        ListProducts TotalListProducts = new ListProducts(null);
        NodeWarehouse pointer = getHead();
        while (pointer != null) {
            ListProducts listProducts = pointer.getElement().getListOfProducts();
            NodeProduct pointerPro = listProducts.getHead();
            while (pointerPro != null) {
                TotalListProducts.AddProduct(pointerPro);
                pointerPro = pointerPro.getNext();
            }
            pointer = pointer.getNext();
        }
        return TotalListProducts;
    }
    
    public Warehouse getWarehouse (String name) {
        NodeWarehouse pointer = getHead();
        while (pointer != null) {
            if (pointer.getElement().getName().equals(name)) {
                return pointer.getElement();
            }
            pointer = pointer.getNext();
        }
        return null;
    }
    
    public int getIndexWarehouse(String WarehouseLetter) {
        int index = 0;
        NodeWarehouse pointerWa = GlobalVariables.getListWarehouse().getHead();
        while (pointerWa != null) {
            if (pointerWa.getElement().getName().equals(WarehouseLetter)) {
                return index;
            }
            index++;
            pointerWa = pointerWa.getNext();
        }
        return -1;
    }
    
    public Warehouse getLast() {
        NodeWarehouse pointer = getHead();
        if (!isEmpty()) {
            while (pointer.getNext()!= null) {
                pointer = pointer.getNext();
            }
            return pointer.getElement();
        }
        return null;

    }
                
}
