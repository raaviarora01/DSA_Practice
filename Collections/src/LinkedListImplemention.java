import java.util.Deque;
import java.util.LinkedList;

public class LinkedListImplemention {
    public static void main(String[] args){
        Deque<Integer> numbers = new LinkedList<>();
        numbers.addFirst(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addLast(40);
        numbers.addLast(50);

        numbers.removeFirst();
        numbers.removeLast();

        System.out.println("Linked List: " + numbers);
    }
}
