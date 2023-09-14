
package solidexample;
/**
 *
 * @author victorpointud
 */

public class Main {
    // Clase main.
        public static void main(String[] args) {
        // Inicio.
            
            System.out.println("--------- APARTADO DE SOLID EXAMPLE --------- \n");
            
            SolidExample example = new SolidExample();
            SolidExample.Database db = example.new Database();
            db.saveData("Datos a guardar en la base de datos.\n");
            SolidExample.Calculator addCalculator = example.new Sum();
            int result = addCalculator.calculate(2, 3);
            System.out.println("El resultado de la suma es: " + result + "\n");
            SolidExample.Calculator subtractCalculator = example.new Subt();
            result = subtractCalculator.calculate(5, 3);
            System.out.println("El resultado de la resta es: " + result + "\n");
            
            System.out.println("------------ APARTADO DE EMPLOYEE ----------- \n");
            
            Employee employee = new Employee("John Doe", "johndoe@example.com", 5000.0);
            Employee.EmployeeRepository repository = employee.new EmployeeDatabaseRepository();
            Employee.EmployeeService service = employee.new EmployeeService(repository);
            service.saveEmployee(employee);
            String email = employee.getEmail();
            String name = employee.getName();
            int salary = (int) employee.getSalary();
            System.out.println("Email: " + email + "\n");
            System.out.println("Nombre: " + name + "\n");
            System.out.println("Salario: " + salary + "\n");
            
            System.out.println("-------------- APARTADO DE FORMS ------------ \n");
            
            Forms rectangle = new Forms(5, 3);
            Square2 square = new Square2(6);
            double rectangleArea = rectangle.calculateArea();
            double squareArea = square.calculateArea();
            System.out.println("Rectangle area: " + rectangleArea + "\n");
            System.out.println("Square area: " + squareArea);
            
            System.out.println("\n-------------- APARTADO DE I ------------- \n");
            
            I i = new I();
            I.MultiFunctionDevice mfd = i.new MultiFunctionDevice();
            mfd.print();
            mfd.scan();
            mfd.fax();
            I.Printer printer = i.new Printer();
            printer.print();
            I.Scanner scanner = i.new Scanner();
            scanner.scan();
            I.FaxMachine faxMachine = i.new FaxMachine();
            faxMachine.fax();
            
            System.out.println("\n------------- APARTADO DE I2 ------------- \n");
            
            I2 i2 = new I2();
            I2.KeyboardReader reader = i2.new KeyboardReader();
            I2.ConsoleWriter writer = i2.new ConsoleWriter();
            I2.TextEditor editor = i2.new TextEditor(reader, writer);
            editor.edit();
           
            System.out.println("------------- APARTADO DE SHAPES ----------- \n");
            
            Shapes rectangle2 = new Shapes(5.0, 3.0);
            Square square2 = new Square(4.0);
            double rectangleArea2 = rectangle2.calculateArea();
            double squareArea2 = square.calculateArea();
            System.out.println("Rectangle area: " + rectangleArea2 + "\n");
            System.out.println("Square area: " + squareArea2);
            
            System.out.println("\n----------------------------------------- \n");
            
        }
}
