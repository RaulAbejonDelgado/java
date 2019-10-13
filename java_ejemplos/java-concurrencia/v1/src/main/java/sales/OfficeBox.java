package sales;

public class OfficeBox implements Runnable {

    Product prod;

    public OfficeBox(Product prd) {
        this.prod = prd;

    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            saleProduct(2);
            try {
                if (prod.getWarehouseQuantity() < 0) {
                    System.out.println("Sorry but the quantity of the product in the warehouse in under 0");
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void saleProduct(int quantity) {
        if (prod.getWarehouseQuantity() >= quantity) {

            System.out.println(String.format("The warehouse quantity of this product is %d", prod.getWarehouseQuantity()));
            System.out.println(String.format("The task of this execution is  %s", Thread.currentThread().getName()));
            prod.saleProduct(quantity);
            System.out.println(String.format("Sale success The warehouse quantity of this product is %d", prod.getWarehouseQuantity()));

        }
    }
}
