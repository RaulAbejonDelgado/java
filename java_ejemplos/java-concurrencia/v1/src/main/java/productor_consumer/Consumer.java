package productor_consumer;

public class Consumer implements Runnable {

    private Buffer buffer;

    public Consumer(Buffer b){
        this.buffer = b;
    }

    public void run() {
        char c;
        for (int i = 0; i < 5; i++) {
            c = buffer.getContent();
            System.out.println(String.format("Consumer : takes  %s", c));
            try {

                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
