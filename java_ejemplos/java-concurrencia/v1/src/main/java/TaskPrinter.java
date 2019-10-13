import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;

public class TaskPrinter implements Runnable{

    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime;
    private final String nameTask;

    public TaskPrinter(String nameTask){
        this.nameTask = nameTask;

        sleepTime = generator.nextInt(5000);

    }

    public void run() {
        try {
            log.info(String.format("%s was going to sleep %d miliseconds", this.nameTask, sleepTime));
            System.out.println(String.format("%s was going to sleep %d miliseconds", this.nameTask, sleepTime));
            Thread.sleep(sleepTime);
        }catch (InterruptedException e){
            log.error(e.getMessage());
            System.out.println(e.getMessage());
            //
            Thread.currentThread().interrupt();
        }
    }
}
