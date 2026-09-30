package List;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackImplementation {
    public static void main(String[] args){
        Deque<String> stack = new ArrayDeque<>();
        stack.push("Java");
        stack.push("Spring");
        stack.push("Docker");

        System.out.println("Top element: " + stack.peek());
        System.out.println("Remove element: " + stack.pop());
        System.out.println("New Top element: " + stack.peek());
        System.out.println("Stack empty?: " + stack.isEmpty());
    }
}
