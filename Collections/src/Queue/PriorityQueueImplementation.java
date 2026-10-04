package Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueImplementation {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(50);
        queue.offer(20);
        queue.offer(30);
        queue.offer(10);
        queue.offer(40);

        System.out.println(queue);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
