package Set;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetImplementation {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(40);
        set.add(10);
        set.add(50);
        set.add(20);
        set.add(30);

        // sorted set
        System.out.println(set);

        // smallest
        System.out.println(set.first());

        // largest
        System.out.println(set.last());

        // lower than 30
        System.out.println(set.lower(30));

        // higher than 30
        System.out.println(set.higher(30));

        // floor of 25
        System.out.println(set.floor(25));

        // ceiling of 25
        System.out.println(set.ceiling(25));

        // Sort Employees by ID using Comparator
        Employee e1 = new Employee(103, "Raavi");
        Employee e2 = new Employee(101, "Aman");
        Employee e3 = new Employee(104, "Karan");
        Employee e4 = new Employee(102, "Neha");
        Employee e5 = new Employee(102, "John");

        Comparator<Employee> byId = Comparator.comparingInt(e -> e.id);
        Set<Employee> employees = new TreeSet<>(byId);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        for(Employee e : employees){
            System.out.println(e.id + " : " + e.name);
        }
    }
}
