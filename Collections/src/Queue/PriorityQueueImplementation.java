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

        // Find Kth largest element
        int k = 2;
        int nums[] = new int[]{3, 2, 1, 5, 6, 4};
        PriorityQueue<Integer> kthLargest = new PriorityQueue<>();

        for(int num : nums){
            kthLargest.offer(num);

            if(kthLargest.size() > k){
                kthLargest.poll();
            }
        }

        System.out.println("2nd largest element: " + kthLargest.peek());

        // Custom Task Priority
        PriorityQueue<Task> tasks = new PriorityQueue<>(Comparator.comparingInt(task -> task.priority));
        tasks.offer(new Task("Send email", 3));
        tasks.offer(new Task("Fix production", 1));
        tasks.offer(new Task("Code review", 2));

        while(!tasks.isEmpty()){
            Task task = tasks.poll();
            System.out.println(task.name);
        }
    }
}

class Task{
    String name;
    int priority;

    public Task(String name, int priority){
        this.name = name;
        this.priority = priority;
    }
}
