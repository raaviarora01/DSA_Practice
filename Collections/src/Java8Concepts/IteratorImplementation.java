package Java8Concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorImplementation {
    public static void main(String[] args) {
        List<Integer> numbers =  new ArrayList<>(Arrays.asList(10, 15, 20, 25, 30, 35));

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()){
            if(iterator.next() % 10 != 0){
                iterator.remove();
            }
        }

        System.out.println("Numbers divisible by 10");
        System.out.println(numbers);
    }
}
