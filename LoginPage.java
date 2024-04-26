import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    RoundedTextField userNameField = new RoundedTextField(10);
    JPasswordField userPasswordField = new JPasswordField();
    RoundedButton loginButton = new RoundedButton("Login");
    RoundedButton resetButton = new RoundedButton("Reset");
    JLabel userNameLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();
    JLabel registerLabel = new JLabel("Don't have an account? Click here to sign up");

    HashMap<String, String> logininfo;

    LoginPage(HashMap<String, String> loginInfoOriginal) {

        logininfo = loginInfoOriginal;

        userNameLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userNameField.setBounds(125, 100, 200, 35);
        userPasswordField.setBounds(125, 150, 200, 35);

        loginButton.setBounds(125, 200, 100, 40);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 40);
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
                messageLabel.setText("Username not found");
            }
        }
    }

    // Custom JTextField subclass for rounded text fields
    class RoundedTextField extends JTextField {
        private Shape shape;

        public RoundedTextField(int size) {
            super(size);
            setOpaque(false); // Make text field transparent
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // Rounded rectangle
            }
            g2.setColor(getBackground());
            g2.fill(shape);
            super.paintComponent(g2);
            g2.dispose();
        }
    }

    // Custom JButton subclass for rounded buttons
    class RoundedButton extends JButton {
        private Color backgroundColor;

        public RoundedButton(String text) {
            super(text);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setOpaque(false);
            setBorderPainted(false);
            setFont(new Font("Arial", Font.PLAIN, 14)); // Set font
            setForeground(Color.WHITE); // Set text color
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Change cursor on hover
            backgroundColor = new Color(66, 135, 245); // Default background color
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            if (getModel().isArmed()) {
                g2.setColor(backgroundColor.darker());
            } else {
                g2.setColor(backgroundColor);
            }

            int width = getWidth();
            int height = getHeight();
            g2.fillRoundRect(0, 0, width, height, height, height); // Rounded rectangle

            g2.setColor(getForeground());
            g2.setFont(getFont());
            FontMetrics metrics = g2.getFontMetrics();
            int textX = (width - metrics.stringWidth(getText())) / 2;
            int textY = ((height - metrics.getHeight()) / 2) + metrics.getAscent();
            g2.drawString(getText(), textX, textY);

            g2.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 40); // Adjust preferred size as needed
        }

        @Override
        public boolean contains(int x, int y) {
            // Check if the mouse is inside the rounded area of the button
            Shape shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
            return shape.contains(x, y);
        }
    }
}
