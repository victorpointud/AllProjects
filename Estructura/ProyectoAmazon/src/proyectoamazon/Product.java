
package proyectoamazon;

/**
 *
 * @author victorpointud
 */
public class Product {
    
    // Métodos.
    
    String name;
    int quantitiy;

    public Product(String name, int quantitiy) {
        this.name = name;
        this.quantitiy = quantitiy;
    }

    // Getters y Setters.
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantitiy() {
        return quantitiy;
    }

    public void setQuantitiy(int quantitiy) {
        this.quantitiy = quantitiy;
    }
}
