package productor_consumer_blockingQueque;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Buffer buffer = new BlockingBuffer();



        executorService.execute(new Productor(buffer));
        executorService.execute(new Consumer(buffer));

        executorService.shutdown();
        try {
            executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
