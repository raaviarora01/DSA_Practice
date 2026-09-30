package Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetImplementation {
    public static void main(String[] args){

        // Print each value that appears as a duplicate only once.
        int[] nums = {10, 20, 30, 10, 40, 20, 50, 10};


        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for(int num : nums){
            if(!seen.add(num)){
                duplicates.add(num);
            }
        }

        System.out.println(duplicates);

        /* Set Operations */
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> b = new HashSet<>(Arrays.asList(4, 5, 6, 7));

        // Intersection
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("Intersection: " + intersection);

        // Union
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union: " + union);

        // Difference
        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.println("Difference: " + difference);

        /* Employee manipulation */
        Employee e1 = new Employee(101, "Raavi");
        Employee e2 = new Employee(102, "Aman");
        Employee e3 = new Employee(101, "Raavi");

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(e1);
        employeeSet.add(e2);
        employeeSet.add(e3);

        System.out.println("Set size: " + employeeSet.size());
    }
}

class Employee{
    int id;
    String name;

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        Employee other = (Employee) obj;

        return this.id == other.id;
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }
}