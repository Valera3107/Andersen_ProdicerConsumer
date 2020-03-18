package ua.com.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Application {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
            new Thread(new NumbersProducer(queue)).start();
            new Thread(new NumbersConsumer(queue)).start();
    }
}
