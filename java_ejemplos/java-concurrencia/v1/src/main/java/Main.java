import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    //public final Logger log = LoggerFactory.getLogger(getClass());


    public static void main(String[] args){


        TaskPrinter task1 = new TaskPrinter("Task1");
        TaskPrinter task2 = new TaskPrinter("Task2");
        TaskPrinter task3 = new TaskPrinter("Task3");

        //og.info("Executing ..................");
        System.out.println("Executing ..................");

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);

        executorService.shutdown();

        //log.info("Started Task, ");
        System.out.println("Started Task, main method finished");

    }

}
