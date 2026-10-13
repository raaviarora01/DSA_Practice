package Java8Concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamImplementation {
    public static void main(String[] args) {
        List<Integer> numbers =  new ArrayList<>(Arrays.asList(5, 2, 8, 1, 10, 3, 6));
        List<Integer> result = numbers.stream()
                .filter(num -> num%2 == 0)
                .map(num -> num * num)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(result);
    }
}
