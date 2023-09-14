
package solidexample;

/**
 *
 * @author victorpointud
 */

public class SolidExample {
// Clase que cumple con el Principio de Responsabilidad Única.
// Se encarga de almacenar los datos en una base de datos.
    
    public class Database {
    
        public void saveData(String data) {
        // Código para guardar los datos en la base de datos.
        }
    }
  
    // Clase que cumple con el Principio de Abierto/Cerrado.
    public abstract class Calculator {
        // Se encarga de realizar un cálculo.
        public abstract int calculate(int x, int y);
    }
  
    // Clase que extiende de Calculator y cumple con el Principio de Sustitución de Liskov.
    public class Sum extends Calculator {
        // Realiza una suma entre dos números.
        public int calculate(int x, int y) {
            return x + y;
        }
    }
  
    // Clase que extiende de Calculator y cumple con el Principio de Sustitución de Liskov.
    public class Subt extends Calculator {
        // Realiza una resta entre dos números.
        public int calculate(int x, int y) {
            return x - y;
        }
    }
  
    // Clase que cumple con el Principio de Segregación de Interfaz.
    public interface Shipping {
        // Solo contiene los métodos necesarios para realizar un envío.
        public void ship(String address, String item);
    } 
  
    // Clase que implementa la interfaz Shipping y cumple con el Principio de Inversión de Dependencia.
    public class ShippingService {
        // No depende directamente de la clase concreta de envío, sino de la interfaz.
        private Shipping shipping;
    
        public ShippingService(Shipping shipping) {
            this.shipping = shipping;
    }
    
        public void shipItem(String address, String item) {
        // Código para preparar el envío.

        // Llamada al método ship de la interfaz Shipping.
        shipping.ship(address, item);
      
        // Código para confirmar el envío.
        }
    }
  
    // Clase que implementa la interfaz Shipping y cumple con el Principio de Inversión de Dependencia.
    public class PostalService implements Shipping {
        public void ship(String address, String item) {
            // Código para enviar el artículo por correo.
        }
    }
  
    // Clase que implementa la interfaz Shipping y cumple con el Principio de Inversión de Dependencia.
    public class CourierService implements Shipping {
        public void ship(String address, String item) {
            // Código para enviar el artículo por mensajería.
        }
    }
}
