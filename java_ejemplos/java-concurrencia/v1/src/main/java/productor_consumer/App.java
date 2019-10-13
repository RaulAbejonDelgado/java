package productor_consumer;

public class App {
    public static void main(String[] args) {
        Buffer b = new Buffer();

        Productor p = new Productor(b);

        Consumer c = new Consumer(b);


        Thread tProd = new Thread(p);
        Thread tCon = new Thread(c);

        tProd.start();
        tCon.start();
    }

}
