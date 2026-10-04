package Queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueImplementation {
    public static void main(String[] args) {
        // Min Heap
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(50);
        queue.offer(20);
        queue.offer(30);
        queue.offer(10);
        queue.offer(40);

        System.out.println(queue);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        // Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(50);
        maxHeap.offer(20);
        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(40);

        System.out.println(maxHeap);
        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll());
        }
    }
}
