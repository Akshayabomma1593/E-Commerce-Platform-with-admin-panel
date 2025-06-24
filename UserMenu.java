import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UserMenu extends JFrame {
    private final String username;
    private final List<Product> cart = new ArrayList<>();

    public UserMenu(JFrame parent, String username) {
        this.username = username;

        setTitle("User Menu - " + username);
        setSize(400, 400);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel welcome = new JLabel("Welcome, " + username + "!");

        JButton viewProducts = new JButton("1. View Products");
        JButton addToCart = new JButton("2. Add to Cart");
        JButton checkout = new JButton("3. Checkout");
        JButton viewOrders = new JButton("4. View Orders");
        JButton logout = new JButton("5. Logout");

        viewProducts.addActionListener(e -> {
            JTextArea area = new JTextArea();
            for (Product p : ProductDB.products) {
                area.append(p.toString() + "\n");
            }
            area.setEditable(false);
            JOptionPane.showMessageDialog(this, new JScrollPane(area), "Product List", JOptionPane.INFORMATION_MESSAGE);
        });

        addToCart.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter product name:");
            for (Product p : ProductDB.products) {
                if (p.name.equalsIgnoreCase(name)) {
                    cart.add(p);
                    JOptionPane.showMessageDialog(this, "✅ Added to cart.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "❌ Product not found.");
        });

        checkout.addActionListener(e -> {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(this, "🛒 Cart is empty.");
                return;
            }
            double total = 0;
            StringBuilder orderSummary = new StringBuilder("Order:\n");
            for (Product p : cart) {
                total += p.price;
                orderSummary.append("- ").append(p.name).append(": $").append(p.price).append("\n");
            }
            orderSummary.append("Total: $").append(total);
            OrderDB.addOrder(username, orderSummary.toString());
            JOptionPane.showMessageDialog(this, orderSummary.toString());
            cart.clear();
        });

        viewOrders.addActionListener(e -> {
            List<String> orders = OrderDB.getOrders(username);
            if (orders.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No orders yet.");
            } else {
                JTextArea area = new JTextArea();
                for (String order : orders) {
                    area.append(order + "\n-----------------------\n");
                }
                area.setEditable(false);
                JOptionPane.showMessageDialog(this, new JScrollPane(area), "Your Orders", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        logout.addActionListener(e -> dispose());

        setLayout(new GridLayout(8, 1, 10, 10));
        add(welcome);
        add(viewProducts);
        add(addToCart);
        add(checkout);
        add(viewOrders);
        add(logout);

        setVisible(true);
    }
}