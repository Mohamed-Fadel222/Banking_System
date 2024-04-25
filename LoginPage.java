import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userNameField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userNameLabel = new JLabel("userName:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel messageLabel = new JLabel();
    JLabel registerLabel = new JLabel("Don't have an account? Click here to sign up");

    HashMap<String, String> logininfo;

    LoginPage(HashMap<String, String> loginInfoOriginal) {

        logininfo = loginInfoOriginal;

        userNameLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userNameField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(userNameLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userNameField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(registerLabel);

        // Add mouse listener to the registerLabel
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setForeground(Color.BLUE);
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new RegisterForm();
                frame.dispose();

            }
        });

        // Set bounds for registerLabel
        registerLabel.setBounds(125, 280, 250, 25);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            userNameField.setText("");
            userPasswordField.setText("");
        }

        if (e.getSource() == loginButton) {

            String userName = userNameField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if (logininfo.containsKey(userName.toLowerCase())) {
                if (logininfo.get(userName).equals(password)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    new home((new Customer()).getCustomerByName(userName.toLowerCase()));

                } else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }

            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("username not found");
            }
        }
    }
}
