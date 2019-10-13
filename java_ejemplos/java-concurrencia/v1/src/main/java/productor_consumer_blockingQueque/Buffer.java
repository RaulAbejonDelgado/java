package productor_consumer_blockingQueque;

public interface Buffer {

    public void blockingPut(int value) throws InterruptedException;

    public int blockingGet() throws InterruptedException;
}
