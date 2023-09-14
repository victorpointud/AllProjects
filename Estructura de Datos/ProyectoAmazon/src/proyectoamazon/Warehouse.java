
package proyectoamazon;

/**
 *
 * @author victorpointud
 */
public class Warehouse {
    
    //Métodos.
    
    ListProducts listOfProducts;
    ListOfArrays links;
    String name;

    public Warehouse(String name, ListProducts listOfProducts) {
        this.name = name;
        this.listOfProducts = listOfProducts;
        this.links = new ListOfArrays(null);
    }
    
    // Getters y Setters.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListProducts getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(ListProducts listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public ListOfArrays getLinks() {
        return links;
    }

    public void setLinks(ListOfArrays links) {
        this.links = links;
    }
    
    public void addProduct(String name, String quantity) {
        int quantityInt = Integer.parseInt(quantity);
        Product pro = new Product(name, quantityInt);
        getListOfProducts().insertEnd(pro);
    }
    
    public void addQuantityProduct () {
        
    }
    
    // Añade link y su tamaño.
    
    public void addLink(String warehouseLetter, String size) {
        String[] result = new String[2];
        result[0] = warehouseLetter;
        result[1] = size;
        getLinks().insertEnd(result);
        System.out.println(result[0]);
        System.out.println(result[1]);
        
    //
    }
    
    

}
