
package solidexample;

/**
 *
 * @author victorpointud
 */

public class Employee {
    
    private String name;
    private String email;
    private double salary;

    public Employee(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public interface EmployeeRepository {
        void save(Employee employee);
        void delete(Employee employee);
    }

    public class EmployeeDatabaseRepository implements EmployeeRepository {
        public void save(Employee employee) {
            // Implementación para guardar empleado en la base de datos
        }

        public void delete(Employee employee) {
            // Implementación para eliminar empleado de la base de datos
        }
    }

    public class EmployeeService {
        private EmployeeRepository employeeRepository;

        public EmployeeService(EmployeeRepository employeeRepository) {
            this.employeeRepository = employeeRepository;
        }

        public void saveEmployee(Employee employee) {
            employeeRepository.save(employee);
        }

        public void deleteEmployee(Employee employee) {
            employeeRepository.delete(employee);
        }
    }

}   

/*

En este ejemplo, la clase Employee tiene la responsabilidad de representar a un
empleado y proporcionar métodos para acceder a sus atributos. La interfaz 
EmployeeRepository definelos métodos para guardar y eliminar empleados en 
cualquier tipo de repositorio (base de datos, memoria, archivo, etc.). La clase
EmployeeDatabaseRepository tiene la responsabilidad de interactuar con la base 
de datos para guardar y eliminar empleados. La clase EmployeeService es 
responsable de proporcionar servicios relacionados con los empleados, como 
guardar y eliminarempleados, utilizando un objeto EmployeeRepository que puede
ser reemplazado por cualquier otro objeto que implemente la interfaz. Con este
diseño, cada clase tiene una sola responsabilidad y hay una separación clara 
entre las diferentes capas de la aplicación.

*/