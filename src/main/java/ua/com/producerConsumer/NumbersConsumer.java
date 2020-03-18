package ua.com.producerConsumer;

import java.util.concurrent.BlockingQueue;

public class NumbersConsumer implements Runnable{
    private BlockingQueue<Integer> queue;

    public NumbersConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    public void run() {
        try {
            while (true) {
                Integer number = queue.take();
                Thread.sleep(2000);
                System.out.println("Consumer consumed: " + number);
                if(queue.size() == 0){
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
