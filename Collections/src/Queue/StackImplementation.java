package Queue;

import java.util.ArrayDeque;

public class StackImplementation {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.push(50);
        System.out.println(stack.peek());

        System.out.println(stack);
    }
}
