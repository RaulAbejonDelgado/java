package productor_consumer_blockingQueque;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Creating a buffer syncronizated using ArrayBlockingQueque
 */
public class BlockingBuffer implements Buffer {

    private final ArrayBlockingQueue<Integer> buffer;

    public BlockingBuffer() {
        this.buffer = new ArrayBlockingQueue<Integer>(1);
    }

    public void blockingPut(int value) throws InterruptedException {
        buffer.put(value);
        System.out.printf("%s %2d\t%s%d%n","The productor writes",value,"Elements in buffer: ", buffer.size());
    }

    public int blockingGet() throws InterruptedException {
        int readValue = buffer.take();
        System.out.printf("%s %2d\t%s%d%n","The Consumer read",readValue,"Elements in buffer: ", buffer.size());

        return readValue;
    }
}
