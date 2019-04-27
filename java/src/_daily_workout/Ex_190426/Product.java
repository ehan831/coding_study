package _daily_workout.Ex_190426;

public class Product {
    int productID;
    static String description;
    String producer;
    int price;

    Product() {
        int productID;
        String description = null;
        String producer = null;
    }

    Product( int productID, String description, String producer) {
        this.productID = productID;
        this.description = description;
        this.producer = producer;
    }

    public void showInfo() {}
}
