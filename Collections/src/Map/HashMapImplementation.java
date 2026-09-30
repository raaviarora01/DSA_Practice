package Map;

import List.StackImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapImplementation {
    public static void main(String[] args) {

        // Create a frequency map
        int[] nums = {
                1, 2, 1, 3, 2, 1, 4, 2
        };
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> mergeMap = new HashMap<>();


        for(int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            mergeMap.merge(num, 1, Integer::sum);
        }

        System.out.println("Frequency Map");
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Merge Map");
        for(Map.Entry<Integer, Integer> entry : mergeMap.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Character frequency
        String str = "programming";

        Map<Character, Integer> charMap = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        char mostFrequent = '\0';
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        System.out.println("Most frequent occuring character: " + mostFrequent + " -> " + max);

        // Group employees by department
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Raavi", "Engineering"));
        employees.add(new Employee("Aman", "HR"));
        employees.add(new Employee("Neha", "Engineering"));
        employees.add(new Employee("Karan", "Finance"));
        employees.add(new Employee("Riya", "Engineering"));

        Map<String, List<String>> departments = new HashMap<>();

        for(Employee employee : employees){
            departments.computeIfAbsent(employee.department, k -> new ArrayList<>()).add(employee.name);
        }

        System.out.println(departments);
    }
}

class Employee {
    String name;
    String department;

    public Employee(String name, String department){
        this.name = name;
        this.department = department;
    }
}
