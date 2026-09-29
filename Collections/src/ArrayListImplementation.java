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
    }
}
