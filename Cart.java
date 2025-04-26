import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cartItems;
    private double totalAmount;

    public Cart() {
        this.cartItems = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    // Method to add a product to the cart
    public void addToCart(Product product) {
        cartItems.add(product);
        totalAmount += product.getProductPrice();
    }

    // Method to get the total amount of the cart
    public double getTotalAmount() {
        return totalAmount;
    }

    // Method to get the list of items in the cart
    public List<Product> getCartItems() {
        return cartItems;
    }

    // Method to clear the cart
    public void clearCart() {
        cartItems.clear();
        totalAmount = 0.0;
    }
}
