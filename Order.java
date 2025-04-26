import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Order {
    private double totalAmount;
    private List<Product> cartItems;

    public Order(double totalAmount, List<Product> cartItems) {
        this.totalAmount = totalAmount;
        this.cartItems = cartItems;
    }

    public void placeOrder() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt", true))) {
            writer.write("Order placed: ");
            writer.newLine();
            for (Product product : cartItems) {
                writer.write(product.getProductDetails());
                writer.newLine();
            }
            writer.write("Total: $" + totalAmount);
            writer.newLine();
            writer.write("------------------------");
            writer.newLine();
            System.out.println("Order placed successfully! Details saved in orders.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
