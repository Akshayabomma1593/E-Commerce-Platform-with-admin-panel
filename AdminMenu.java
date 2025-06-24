import javax.swing.*;
import java.awt.*;

public class AdminMenu extends JFrame {
    public AdminMenu(JFrame parent, String username) {
        setTitle("Admin Menu - " + username);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel welcome = new JLabel("Welcome, " + username + "! Select an option:");
        JButton addProduct = new JButton("1. Add Product");
        JButton viewProducts = new JButton("2. View Product List");
        JButton viewOrders = new JButton("3. View Orders");
        JButton logout = new JButton("4. Logout");

        addProduct.addActionListener(e -> new AddProductWindow(this));
        //removeProduct.addActionListener(e -> JOptionPane.showMessageDialog(this, "Remove feature coming soon."));
        viewProducts.addActionListener(e -> JOptionPane.showMessageDialog(this, ProductDB.products.toString()));
        viewOrders.addActionListener(e ->{
            StringBuilder allOrders = new StringBuilder();
            for(String user : OrderDB.userOrders.keySet()){
                allOrders.append(user).append("s Orders:\n");
                for(String order: OrderDB.getOrders(user)){
                    allOrders.append(order).append("\n--------------------------------\n");
                }
            }
            JTextArea area = new JTextArea(allOrders.toString());
            area.setEditable(false);
            JOptionPane.showMessageDialog(this, new JScrollPane(area),"All Orders",JOptionPane.INFORMATION_MESSAGE);
        });
        logout.addActionListener(e -> dispose());

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        panel.add(welcome);
        panel.add(addProduct);
        //panel.add(removeProduct);
        panel.add(viewProducts);
        panel.add(viewOrders);
        panel.add(logout);

        add(panel);
        setVisible(true);
    }
}
