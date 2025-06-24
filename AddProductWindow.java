import javax.swing.*;
import java.awt.*;

public class AddProductWindow extends JFrame {
    public AddProductWindow(JFrame parent) {
        setTitle("Admin - Add Product");
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel nameLabel = new JLabel("Product Name:");
        JTextField nameField = new JTextField();
        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField();

        JButton addBtn = new JButton("Add Product");

        addBtn.addActionListener(e -> {
            String name = nameField.getText();
            double price;
            try {
                price = Double.parseDouble(priceField.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid price.");
                return;
            }
            ProductDB.addProduct(name, price);
            JOptionPane.showMessageDialog(this, "✅ Product added.");
            dispose();
        });

        setLayout(new GridLayout(3, 2, 10, 10));
        add(nameLabel); add(nameField);
        add(priceLabel); add(priceField);
        add(addBtn);

        setVisible(true);
    }
}
