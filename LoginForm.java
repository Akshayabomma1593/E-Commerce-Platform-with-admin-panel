import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {
    public LoginForm(JFrame parent, String role) {
        setTitle("Login - " + role.toUpperCase());
        setSize(350, 200);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");
        JButton cancelBtn = new JButton("Cancel");

        loginBtn.addActionListener(e -> {
            String username = userField.getText().trim();
            String password = new String(passField.getPassword()).trim();

            boolean isValid = false;

            if (role.equals("user")) {
                isValid = UserDB.customers.containsKey(username) && UserDB.customers.get(username).equals(password);
            } else if (role.equals("admin")) {
                isValid = UserDB.admins.containsKey(username) && UserDB.admins.get(username).equals(password);
            }

            if (isValid) {
                JOptionPane.showMessageDialog(this, "✅ Login successful.");
                dispose();
                if (role.equals("user")) {
                    new UserMenu(parent, username);
                } else if(role.equals("admin")){
                    new AdminMenu(parent, username);
                }
            } else {
                JOptionPane.showMessageDialog(this, "❌ Invalid credentials. Please try again.");
            }
        });

        cancelBtn.addActionListener(e -> dispose());

        setLayout(new GridLayout(4, 2, 10, 10));
        add(userLabel); add(userField);
        add(passLabel); add(passField);
        add(loginBtn); add(cancelBtn);

        setVisible(true);
    }
}
