import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Raavi");
        names.add("John");
        names.add("Karan");
        names.add("Aman");

        System.out.println("----------------- List Contents -----------------");
        for(String name : names) {
            System.out.println(name);
        }

        System.out.println("Size: " + names.size());
        System.out.println("First element: " + names.get(0));
        System.out.println("Does Karan exist?: " + names.contains("Karan"));

        names.remove(names.indexOf("Aman"));

        System.out.println("----------------- List Contents -----------------");
        Iterator<String> iter = names.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        Map<Integer, String> employees = new HashMap<>();
        employees.put(101, "Raavi");
        employees.put(102, "Aman");
        employees.put(103, "Neha");

        employees.put(102, "Karan");

        System.out.println("Total no of employees: " + employees.size());
        System.out.println("Employee with ID 102: " + employees.get(102));

        Employee e1 = new Employee(1, "Raavi");
        Employee e2 = new Employee(1, "Raavi");

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(e1);
        employeeSet.add(e2);

        System.out.println(employeeSet.size());
    }
}

class Employee{
    int id;
    String name;

    public Employee(int i, String raavi) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if(this ==  obj) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        Employee other = (Employee) obj;

        return this.id == other.id;
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(id);
    }
}