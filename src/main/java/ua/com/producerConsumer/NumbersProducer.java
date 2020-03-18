package ua.com.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class NumbersProducer implements Runnable {
    private BlockingQueue<Integer> numbersQueue;

    public NumbersProducer(BlockingQueue<Integer> numbersQueue) {
        this.numbersQueue = numbersQueue;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                System.out.println("Queue size: " + numbersQueue.size());
                generateNumbers();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void generateNumbers() throws InterruptedException {
            int number = ThreadLocalRandom.current().nextInt(100);
            System.out.println("Producer produced: " + number);
            numbersQueue.put(number);
    }
}
