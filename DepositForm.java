import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class DepositForm implements ActionListener {
    private JFrame frame;
    private JLabel depositLabel;
    private RoundedTextField amountField;
    private RoundedButton confirmButton;
    private RoundedButton homeButton;
    private Customer customer;

    public DepositForm(Customer customer) {
        this.customer = customer;

        frame = new JFrame("Deposit");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null); // Use null layout
        frame.getContentPane().setBackground(new Color(0xD5DCF9));
        depositLabel = new JLabel("Enter the amount to deposit: Current Balance is " + customer.getAccount().InitialBalance);
        amountField = new RoundedTextField(10);
        confirmButton = new RoundedButton("Confirm", 20, 20);
        homeButton = new RoundedButton("Home", 20, 20);


        confirmButton.addActionListener(this);
        homeButton.addActionListener(this);

        frame.add(depositLabel);
        frame.add(amountField);
        frame.add(confirmButton);
        frame.add(homeButton);

        // Set bounds for components
        int labelWidth = 320;
        int labelHeight = 60;
        int fieldWidth = 250;
        int fieldHeight = 30;
        int buttonWidth = 100;
        int buttonHeight = 40;

        int horizontalPadding = 20;
        int verticalPadding = 10;

        int startY = (frame.getHeight() - labelHeight - fieldHeight - buttonHeight - 4 * verticalPadding) / 2;

        depositLabel.setBounds((frame.getWidth() - labelWidth) / 2, startY, labelWidth, labelHeight);
        amountField.setBounds((frame.getWidth() - fieldWidth) / 2, startY + labelHeight + verticalPadding, fieldWidth, fieldHeight);
        confirmButton.setBounds((frame.getWidth() - buttonWidth) / 2, startY + 2 * (labelHeight + verticalPadding) + fieldHeight, buttonWidth, buttonHeight);
        homeButton.setBounds((frame.getWidth() - buttonWidth) / 2, startY + 3 * (labelHeight + verticalPadding) + 2 * fieldHeight, buttonWidth, buttonHeight);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(frame, "Invalid amount. Amount must be greater than 0.");
            } else {
                customer.deposit(amount);
                JOptionPane.showMessageDialog(frame, "Deposited " + amount + " to your account.");
                depositLabel.setText("Enter the amount to deposit: Current Balance is " + customer.getAccount().InitialBalance);
                amountField.setText("");
            }
        } else if (e.getSource() == homeButton) {
            frame.dispose();
            new home(customer);
        }
    }

    // Custom JTextField subclass for rounded text fields
    class RoundedTextField extends JTextField {
        private Shape shape;

        public RoundedTextField(int size) {
            super(size);
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding
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
        private int arcWidth;
        private int arcHeight;

        public RoundedButton(String text, int arcWidth, int arcHeight) {
            super(text);
            this.arcWidth = arcWidth;
            this.arcHeight = arcHeight;
            setForeground(Color.WHITE); // Set text color
            setFont(new Font("Arial", Font.PLAIN, 16)); // Set font
            setFocusable(false);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setOpaque(true);
            setBackground(new Color(66, 135, 245));
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setPreferredSize(new Dimension(100, 40));
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isPressed()) {
                g.setColor(new Color(66, 135, 245).darker());
            } else {
                g.setColor(new Color(66, 135, 245));
            }
            g.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
            super.paintComponent(g);
        }
    }

}