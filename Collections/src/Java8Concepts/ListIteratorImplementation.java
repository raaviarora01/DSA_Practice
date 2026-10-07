package Java8Concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorImplementation {
    public static void main(String[] args) {
        List<String> tech = new ArrayList<>(Arrays.asList("Java", "Spring", "Docker"));

        // Replace Spring with Spring Boot
        ListIterator<String> iter = tech.listIterator();
        while(iter.hasNext()){
            String value = iter.next();

            if(value.equals("Spring")){
                iter.set("Spring Boot");
            }

            if(value.equals("Java")){
                iter.add("SQL");
            }
        }

        System.out.println("List : " + tech);

        // Print the list backwards
        while(iter.hasPrevious()){
            System.out.println(iter.previous());
        }
    }
}
