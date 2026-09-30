package List;

import java.util.ArrayList;
import java.util.List;

public class ArrayListImplementation {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        list.add(1, 40);

        list.remove(2);

        list.set(0, 100);

        System.out.println(list);

        list.remove(list.indexOf(40));

        System.out.println(list);

        List<String> technologies = new ArrayList<>();
        technologies.add("Java");
        technologies.add("Spring");
        technologies.add("Docker");
        technologies.add("SQL");
        technologies.add("AWS");

        // insert "Hibernate" between Spring and Docker
        technologies.add(2, "Hibernate");

        // remove "SQL"
        technologies.remove("SQL");

        // replace "AWS" with "Azure"
        int ind = technologies.indexOf("AWS");
        technologies.set(ind, "Azure");

        // print every element with its index
        for(String tech : technologies){
            System.out.println(technologies.indexOf(tech) + " -> " + tech);
        }

        // check whether "Spring" exists
        System.out.println("Spring exists?: " + technologies.contains("Spring"));

        // print the final size
        System.out.println("List size: " + technologies.size());

    }
}
