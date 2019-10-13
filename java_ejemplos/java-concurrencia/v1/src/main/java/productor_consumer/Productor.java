package productor_consumer;

public class Productor implements Runnable {

    private Buffer buffer;
    private final String letters="abcdefghijklmnopqrstuvwxz";

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        char c;
        for (int i = 0; i < 5; i++) {
            c = letters.charAt((int)(Math.random()* letters.length()));
            buffer.setContent(c);
            System.out.println(String.format("Productor %s", c));
            try {

                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
