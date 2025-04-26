import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class ShoppingGUI {
    private JFrame frame;
    private JButton btnBrowse, btnAddToCart, btnPlaceOrder;
    private JTextArea cartDisplay;
    private Cart cart;
    private List<Product> products;

    public ShoppingGUI() {
        frame = new JFrame("Online Shopping System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        btnBrowse = new JButton("Browse Products");
        btnAddToCart = new JButton("Add to Cart");
        btnPlaceOrder = new JButton("Place Order");
        cartDisplay = new JTextArea(10, 30);

        cart = new Cart();
        products = new ArrayList<>();

        panel.add(btnBrowse);
        panel.add(btnAddToCart);
        panel.add(btnPlaceOrder);
        panel.add(new JScrollPane(cartDisplay));

        btnBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                browseProducts();
            }
        });

        btnAddToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });

        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private void browseProducts() {
        products.clear();
        // In-memory product data
        products.add(new Product(1, "Laptop", 1000));
        products.add(new Product(2, "Phone", 500));
        products.add(new Product(3, "Headphones", 150));

        cartDisplay.setText("");
        for (Product product : products) {
            cartDisplay.append(product.getProductDetails() + "\n");
        }
    }

    private void addToCart() {
        String input = JOptionPane.showInputDialog(frame, "Enter product ID to add to cart:");
        int productId = Integer.parseInt(input);

        Product selectedProduct = null;
        for (Product product : products) {
            if (product.getProductId() == productId) {
                selectedProduct = product;
                break;
            }
        }

        if (selectedProduct != null) {
            cart.addToCart(selectedProduct);
            JOptionPane.showMessageDialog(frame, "Product added to cart!");
        } else {
            JOptionPane.showMessageDialog(frame, "Product not found!");
        }
    }

    private void placeOrder() {
        double totalAmount = cart.getTotalAmount();
        if (totalAmount > 0) {
            Order order = new Order(totalAmount, cart.getCartItems());
            order.placeOrder();
            cartDisplay.setText("Order placed successfully!");
        } else {
            JOptionPane.showMessageDialog(frame, "Cart is empty!");
        }
    }

    public static void main(String[] args) {
        new ShoppingGUI();
    }
}
