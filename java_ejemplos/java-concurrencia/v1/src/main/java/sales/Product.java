package sales;

public class Product {

    private int warehouseQuantity;
    private String name;

    public Product(int warehouseQuantity, String name) {
        this.warehouseQuantity = warehouseQuantity;
        this.name = name;
    }

    public int getWarehouseQuantity() {
        return warehouseQuantity;
    }

    public void setWarehouseQuantity(int warehouseQuantity) {
        this.warehouseQuantity = warehouseQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void saleProduct(int quantity){
        this.warehouseQuantity -= quantity;
    }
}
