import javax.swing.*;
import java.awt.*;

public class RegisterForm extends JFrame {
    public RegisterForm(JFrame parent, String role) {
        setTitle("Register as " + role.toUpperCase());
        setSize(350, 250);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JLabel confirmLabel = new JLabel("Confirm Password:");
        JPasswordField confirmField = new JPasswordField();

        JButton registerBtn = new JButton("Register");
        JButton cancelBtn = new JButton("Cancel");

        registerBtn.addActionListener(e -> {
            String username = userField.getText().trim();
            String password = new String(passField.getPassword()).trim();
            String confirm = new String(confirmField.getPassword()).trim();

            if (!password.equals(confirm)) {
                JOptionPane.showMessageDialog(this, "❌ Passwords do not match.");
                return;
            }

            if (!isValidPassword(password)) {
                JOptionPane.showMessageDialog(this, "❌ Password must contain:\n- Min 6 chars\n- 1 uppercase\n- 1 lowercase\n- 1 digit\n- 1 special char");
                return;
            }

            if (role.equals("user")) {
                if (UserDB.customers.containsKey(username)) {
                    JOptionPane.showMessageDialog(this, "❌ Username already exists.");
                    return;
                }
                UserDB.customers.put(username, password);
            } else {
                if (UserDB.admins.containsKey(username)) {
                    JOptionPane.showMessageDialog(this, "❌ Admin already exists.");
                    return;
                }
                UserDB.admins.put(username, password);
            }

            JOptionPane.showMessageDialog(this, "✅ " + role + " registered successfully.");
            dispose();
        });

        cancelBtn.addActionListener(e -> dispose());

        setLayout(new GridLayout(5, 2, 10, 10));
        add(userLabel); add(userField);
        add(passLabel); add(passField);
        add(confirmLabel); add(confirmField);
        add(registerBtn); add(cancelBtn);

        setVisible(true);
    }

    private boolean isValidPassword(String pass) {
        if (pass.length() < 6) return false;
        boolean upper = false, lower = false, digit = false, special = false;
        for (char c : pass.toCharArray()) {
            if (Character.isUpperCase(c)) upper = true;
            else if (Character.isLowerCase(c)) lower = true;
            else if (Character.isDigit(c)) digit = true;
            else if ("!@#$%^&*()_+-={}[]|:;<>,.?/".indexOf(c) >= 0) special = true;
        }
        return upper && lower && digit && special;
    }
}
