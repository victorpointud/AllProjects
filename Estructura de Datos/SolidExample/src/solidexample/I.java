
package solidexample;

/**
 *
 * @author victorpointud
 */

public class I {
    
    public interface IPrinter {
        void print();
    
    }
    public interface IScanner {
        void scan();
    
    }
    public interface IFax {
        void fax();
        
    }
    
    public class MultiFunctionDevice implements IPrinter, IScanner, IFax {
        public void print() {
            System.out.println("Printing...");
        }

        public void scan() {
            System.out.println("Scanning...");
        }

        public void fax() {
            System.out.println("Faxing...");
        }
    }

    public class Printer implements IPrinter {
        public void print() {
            System.out.println("Printing...");
        }
    }

    public class Scanner implements IScanner {
        public void scan() {
            System.out.println("Scanning...");
        }
    }

    public class FaxMachine implements IFax {
        public void fax() {
            System.out.println("Faxing...");
        }
    }
    
}

/*

En este ejemplo, tenemos tres interfaces distintas: IPrinter, IScanner e IFax. 
Cada una de estas interfaces representa una única responsabilidad. Luego, 
tenemos una clase MultiFunctionDevice que implementa las tres interfaces para 
proporcionar una impresora, un escáner y una máquina de fax.

También tenemos tres clases separadas que implementan cada una de las
interfaces: Printer, Scanner y FaxMachine. Cada una de estas clases proporciona 
una única funcionalidad y cumple con el principio ISP.

Finalmente, en la clase Main, podemos ver cómo podemos crear diferentes objetos 
según nuestras necesidades. Si necesitamos una impresora, podemos crear un
objeto de la clase Printer y llamar al método print(). Si necesitamos una 
máquina de fax, podemos crear un objeto de la clase FaxMachine y llamar al 
método fax(). Y si necesitamos una máquina multifunción, podemos crear un 
objeto de la clase MultiFunctionDevice y llamar a cualquiera de los tres 
métodos que proporciona.

Este diseño cumple con el principio ISP, ya que cada interfaz representa una 
única responsabilidad y cada clase implementa solo las interfaces que necesita 
para proporcionar su funcionalidad específica. No hay ninguna clase que 
implemente una interfaz que no necesite, y todas las clases proporcionan una 
única responsabilidad.

*/