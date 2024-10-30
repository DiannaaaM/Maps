import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
public class Main {
    private static Map<Integer, Employee> employees;
    public Main() {
        employees = new HashMap<>();
        employees.put(123, new Employee("Иван", "Иванов"));
        employees.put(124, new Employee("Дмитрий", "Александров"));
        employees.put(125, new Employee("Евгений", "Александров"));
        employees.put(126, new Employee("Екатерина", "Иванова"));
        employees.put(127, new Employee("Ivan", "Ivanov"));
        employees.put(128, new Employee("Kate", "Vasnetcova"));
        employees.put(129, new Employee("Ivan", "Ivanov"));
        employees.put(130, new Employee("Ivan", "Ivanov"));
        employees.put(131, new Employee("Ivan", "Ivanov"));
        employees.put(132, new Employee("Ivan", "Ivanov"));
    }

    public static String addEmployee(int passport, String name, String lastName) throws EmployeeAlreadyAddedException {
        if (employees.containsKey(passport)) {
            throw new EmployeeAlreadyAddedException("В коллекции уже есть сотрудник с таким же паспортом.");
        }
        Employee newEmployee = new Employee(name, lastName);
        employees.put(passport, newEmployee);
        return newEmployee.toString();
    }

    public static String deleteEmployee(int passport) throws EmployeeNotFoundExeption {
        Employee employeeToDelete = employees.get(passport);
        if (employeeToDelete == null) {
            throw new EmployeeNotFoundExeption("Employee not found");
        }
        employees.remove(passport);
        return employeeToDelete.toString();
    }

    public static String findEmployee(int passport) throws EmployeeNotFoundExeption {
        Employee employee = employees.get(passport);
        if (employee == null) {
            throw new EmployeeNotFoundExeption("Employee not found");
        }
        return employee.getFullName();
    }
    public static void main(String[] args) {
        Main main = new Main();
        try {
            String emp = main.addEmployee(451, "Svetlana", "Nikitina");
            String emp1 = main.findEmployee(451);
            String emp2 = main.deleteEmployee(451);
            System.out.println(emp);
            System.out.println(emp1);
            System.out.println(emp2);
        } catch (EmployeeAlreadyAddedException | EmployeeNotFoundExeption e) {
            throw new RuntimeException(e);
        }
    }
}
