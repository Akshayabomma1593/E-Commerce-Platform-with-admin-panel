import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Welcome to E-commerce");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton loginUser = new JButton("Existing User Login");
        JButton registerUser = new JButton("New User Registration");
        JButton adminLogin = new JButton("Login as Admin");
        JButton exit = new JButton("Exit");

        loginUser.addActionListener(e -> new LoginForm(this, "user"));
        registerUser.addActionListener(e -> new RegisterForm(this, "user"));
        adminLogin.addActionListener(e -> new LoginForm(this, "admin"));
        exit.addActionListener(e -> System.exit(0));

        setLayout(new GridLayout(5, 1, 10, 10));
        add(new JLabel("Welcome to E-commerce", SwingConstants.CENTER));
        add(loginUser);
        add(registerUser);
        add(adminLogin);
        add(exit);

        setVisible(true);
    }
}