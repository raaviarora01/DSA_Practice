package MapMultithreadingExperiment;

import java.util.*;
import java.util.concurrent.*;

public class MapConcurrencyExperiment {
    static final int THREADS = 8;
    static final int OPERATIONS = 10000;

    public static void main(String[] args) throws InterruptedException {
        testMap("HashMap", new HashMap<>());
        testMap("Hashtable", new Hashtable<>());
        testMap("SynchronizedMap", Collections.synchronizedMap(new HashMap<>()));
        testMap("ConcurrentHashMap", new ConcurrentHashMap<>());
    }

    static void testMap(String name, Map<Integer, Integer> map) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        CountDownLatch start = new CountDownLatch(1);
        long startTime = System.nanoTime();
        for(int t = 0; t < THREADS; t++){
            final int threadId = t;

            executor.submit(() -> {
                try {
                    start.await();

                    for(int i = 0; i < OPERATIONS; i++){

                        // Each thread inserts unique key
                        int key = threadId * OPERATIONS + i;
                        map.put(key, i);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Allow all workers to begin
        start.countDown();

        executor.shutdown();

        executor.awaitTermination(1, TimeUnit.MINUTES);

        long elapsed = System.nanoTime() - startTime;

        System.out.printf("%-20s Size: %-8d Time: %.2f ms%n",
                name,
                map.size(),
                elapsed/1_000_000.0
        );
    }
}
