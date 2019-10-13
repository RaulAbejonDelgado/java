package productor_consumer;

public class Buffer {

    private char content;
    private boolean available = false;

    public synchronized char getContent() {

        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        available = false;
        notify();
        return content;

    }

    public synchronized void setContent(char c) {
        while(available){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        content = c;
        available = true;
        notify();

    }

}
