package proyectoislas;

/**
 *
 * @author victorpointud
 */

/**
* Representa a un nodo con el tipo de dato T (ej. Integer, User, etc)
*/

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }

    /**
    * Obtiene el Dato.
    */
    public T getData() {
        return data;
    }

    /**
    * Setea el Dato.
    */
    public void setData(T data) {
        this.data = data;
    }

    /**
    * Obtiene el Siguiente.
    */
    public Node<T> getNext() {
        return next;
    }

    /**
    * Setea el Siguiente.
    */
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    
}