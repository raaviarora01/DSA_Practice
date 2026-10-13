package Java8Concepts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingImplementation {
    public static void main(String[] args) {
        List<EmployeeDetails> employeeDetails = new ArrayList<>();
        employeeDetails.add(new EmployeeDetails(103, "Karan", 70000));
        employeeDetails.add(new EmployeeDetails(101, "Raavi", 90000));
        employeeDetails.add(new EmployeeDetails(104, "Aman", 70000));
        employeeDetails.add(new EmployeeDetails(102, "Neha", 80000));

        employeeDetails.sort(
                Comparator
                        .comparingInt(EmployeeDetails::getSalary)
                        .reversed()
                        .thenComparing(EmployeeDetails::getId)
        );

        System.out.println(employeeDetails);
    }
}

class EmployeeDetails{
    int id;
    String name;
    int salary;

    public EmployeeDetails(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
