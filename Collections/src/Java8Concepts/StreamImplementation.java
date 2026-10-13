package Java8Concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamImplementation {
    public static void main(String[] args) {

        // Return a list of even squared numbers in descending order
        List<Integer> numbers =  new ArrayList<>(Arrays.asList(5, 2, 8, 1, 10, 3, 6));
        List<Integer> result = numbers.stream()
                .filter(num -> num%2 == 0)
                .map(num -> num * num)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(result);

        // Return a list of employee names in engineering department sorted by salary descending
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Raavi", "Engineering", 70000));
        employees.add(new Employee("Aman", "HR", 60000));
        employees.add(new Employee("Neha", "Engineering", 90000));
        employees.add(new Employee("Karan", "Finance", 80000));
        employees.add(new Employee("Riya", "Engineering", 75000));

        List<String> filteredEmployees = employees.stream()
                .filter(emp -> emp.department.equals("Engineering"))
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .map(Employee::getName)
                .toList();

        System.out.println(filteredEmployees);
    }
}

class Employee{
    String name;
    String department;
    int salary;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
