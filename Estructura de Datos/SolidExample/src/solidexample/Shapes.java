
package solidexample;

/**
 *
 * @author victorpointud
 */

public class Shapes {
    private double length;
    private double width;

    public Shapes(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }
}

class Square {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double calculateArea() {
        return side * side;
    }
}



/*

En este ejemplo, la interfaz Shapes define un método area() que devuelve el área 
de una forma geométrica. Las clases Rectangle y Circle implementan esta interfaz 
y proporcionan una implementación específica del método area() para calcular el 
área de un rectángulo y un círculo, respectivamente. La clase AreaCalculator 
utiliza un arreglo de objetos Shapes para calcular el área total de todas las 
formas en el arreglo, independientemente de su tipo específico.

Este diseño cumple con el principio OCP, ya que es abierto para la extensión y 
cerrado para la modificación. Si se desea agregar un nuevo tipo de forma, 
simplemente se debe crear una nueva clase que implemente la interfaz Shapes y 
proporcione su propia implementación del método area(), sin necesidad de 
modificar el código existente en la clase AreaCalculator o en cualquier otra 
clase que utilice la interfaz Shapes.

*/