public class Product {
    private int productId;
    private String productName;
    private double productPrice;

    // Constructor
    public Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    // Method to display product details
    public String getProductDetails() {
        return "ID: " + productId + " | Name: " + productName + " | Price: $" + productPrice;
    }
}
