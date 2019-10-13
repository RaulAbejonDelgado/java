package productor_consumer_blockingQueque;

import java.security.SecureRandom;

public class Consumer implements Runnable {

    private static final SecureRandom generator = new SecureRandom();
    private Buffer buffer;

    public Consumer(Buffer b){
        this.buffer = b;
    }

    public void run() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(generator.nextInt(3000));
                sum += buffer.blockingGet();
                System.out.printf("\t\t\t%2d%n", sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("%n%s %d%n%s%n","The consumer has been read all values", sum , "Consumer finished");
    }
}
