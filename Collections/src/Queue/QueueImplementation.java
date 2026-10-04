package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueImplementation {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue.peek());
        queue.poll();
        queue.offer(40);
        queue.poll();
        System.out.println(queue.peek());
    }
}
