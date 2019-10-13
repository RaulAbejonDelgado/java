package sales;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SalesPoint {

    public static void main(String[] args) {


        Product product = new Product(30, "Keyboard");
        OfficeBox officeBox = new OfficeBox(product);
        //og.info("Executing ..................");
        System.out.println("Executing ..................");

        ExecutorService executorService = Executors.newCachedThreadPool();

        Thread raul = new Thread(officeBox,"Raul");
        Thread juan = new Thread(officeBox,"Juan");
        Thread pepe = new Thread(officeBox,"Pepe");
        Thread marisa = new Thread(officeBox,"Marisa");
        Thread jabibi = new Thread(officeBox,"Jabibi");

        raul.start();
        juan.start();
        pepe.start();
        marisa.start();
        jabibi.start();

        executorService.shutdown();

        //log.info("Started Task, ");
        System.out.println("Started Task, main method finished");

    }


}
