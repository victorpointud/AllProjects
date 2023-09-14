package proyectoislas;

/**
 *
 * @author victorpointud
 */

/**
* Esta clase corresponde a una implementación de una lista enlazada con el tipo de dato T.
*/
class LinkedList<T> {
    Node<T> head;
    int size = 0;

    /**
    * Obtiene la Cabeza.
    */
    public Node<T> getHead() {
        return head;
    }

    /**
    * Setea la Cabeza.
    */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
    * Obtiene el Tamaño.
    */
    public int getSize() {
        return size;
    }

    /**
    * Setea el Tamaño.
    */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    /**
    * Añade un nuevo nodo de tipo T.
    */
    public void append(T data){
        Node<T> newNode = new Node<>(data);
        if(this.getHead() == null){
            this.head = newNode;
        } else {
            Node<T> current = this.getHead();
            while(current.getNext() != null)
                current = current.getNext();
            current.next = newNode;
        }
        this.size++;
    }

    /**
    * Obtiene el nodo en la posición 'index' de la lista enelazada.
    */
    public Node<T> get(int index){
        if(this.getHead() == null)
            return null;
        if(index == 0)
            return this.head;
        int i = 1;
        Node current = this.getHead();
        while(current.getNext() != null){
            if(i == index)
                return current.getNext();
            current = current.getNext();
            i++;
        }
        return null;
    }
    
    /**
    * Elimina al nodo que corresponde al dato T dado en la 'key'.
    */
    public void delete(T key){
        if(this.getHead() == null)
            return;
        if(this.getHead().getData() == key){
            this.head = this.getHead().getNext();
            this.size--;
            return;
         }
        Node current = this.getHead();
        while(current.getNext() != null){
            if(current.getNext().getData() == key){
                current.next = current.getNext().getNext();
                this.size--;
                return;
            }
            current = current.getNext();
        }
    }
}

