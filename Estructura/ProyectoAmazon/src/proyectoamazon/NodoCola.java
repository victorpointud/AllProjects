
package proyectoamazon;

/**
 *
 * @author victorpointud
 */
public class NodoCola<T> {
    
    // Métodos.
    private T data;
    private NodoCola siguiente;

    public NodoCola(T data) {
        this.data = data;
        this.siguiente = null;
    }

    // Getters y Setters.
    
    public T getElemento() {
        return data;
    }

    public void setElemento(T data) {
        this.data = data;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
}
