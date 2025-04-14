import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name + " | Age: " + age + " | Salary: " + salary;
    }
}

public class SortEmployees {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 50000),
            new Employee("Bob", 25, 60000),
            new Employee("Charlie", 28, 55000)
        );

        System.out.println("Sorted by Name:");
        employees.stream()
                 .sorted(Comparator.comparing(e -> e.name))
                 .forEach(System.out::println);

        System.out.println("\nSorted by Age:");
        employees.stream()
                 .sorted(Comparator.comparingInt(e -> e.age))
                 .forEach(System.out::println);

        System.out.println("\nSorted by Salary:");
        employees.stream()
                 .sorted(Comparator.comparingDouble(e -> e.salary))
                 .forEach(System.out::println);
    }
}
