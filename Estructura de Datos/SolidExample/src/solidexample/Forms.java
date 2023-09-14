
package solidexample;

/**
 *
 * @author victorpointud
 */

public class Forms {
    private double length;
    private double width;

    public Forms(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }
}

class Square2 {
    private double side;

    public Square2(double side) {
        this.side = side;
    }

    public double calculateArea() {
        return side * side;
    }
}

/*

En este ejemplo, la clase Forms representa un rectángulo con un ancho y un
alto. La clase Square extiende la clase Forms y representa un cuadrado con
lados iguales. Se sobrescriben los métodos setWidth() y setHeight() en la clase
Square para asegurarse de que siempre se establezcan los lados iguales.

La clase AreaCalculator utiliza un arreglo de objetos Forms para calcular 
el área total de todas las formas en el arreglo. Se utiliza un objeto Square en 
el arreglo para demostrar que cumple con el principio LSP, ya que se puede 
utilizar en lugar de un objeto Forms sin cambiar el comportamiento del 
programa.

Este diseño cumple con el principio LSP, ya que la clase Square se puede 
utilizar en lugar de la clase Forms sin cambiar el comportamiento del 
programa. Ambas clases tienen un método area() que devuelve el área de la forma 
geométrica, y la clase Square proporciona una implementación específica de los 
métodos setWidth() y setHeight() que aseguran que siempre se establezcan los 
lados iguales.

*/