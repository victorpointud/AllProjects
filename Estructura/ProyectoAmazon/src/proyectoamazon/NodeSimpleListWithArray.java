
package proyectoamazon;

/**
 *
 * @author victorpointud
 */
public class NodeSimpleListWithArray {
   
    // Métodos.
    
    private String data;
    private int next;

    public NodeSimpleListWithArray(String data) {
        this.data = data;
        this.next = -1;
    }

    // Getters y Setters.
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }
}
