import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class transform {

    private JPanel transPanel;
    private JButton button1;
    private JLabel text2;
    private JButton button2;

    private Customer customer;
    private JFrame tr;

    public transform(Customer customer) {
        this.customer = customer;

        tr = new JFrame();
        tr.setSize(600, 600);
        tr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        tr.setVisible(true);

        initComponents();
        addListeners();

        tr.setContentPane(transPanel);
    }

    private void initComponents() {
        transPanel = new JPanel(new BorderLayout()); // Use BorderLayout for the main panel

        // Create a panel for buttons and add them to the SOUTH (bottom) of the main panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Center-align buttons
        button1 = new JButton("Show Transaction History");
        button2 = new JButton("Back to Home");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        transPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Create a JScrollPane for the text area
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Create a label for text and set its font size and preferred size
        text2 = new JLabel();
        text2.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjust font size as needed
        text2.setVerticalAlignment(SwingConstants.TOP); // Align text to the top
        text2.setVerticalTextPosition(SwingConstants.TOP); // Align text to the top
        text2.setHorizontalTextPosition(SwingConstants.LEFT); // Align text to the left
        text2.setPreferredSize(new Dimension(400, 300)); // Adjust preferred size as needed

        // Add the label to the scroll pane
        scrollPane.setViewportView(text2);

        // Add the scroll pane to the NORTH (top) of the main panel
        transPanel.add(scrollPane, BorderLayout.NORTH);
    }

    private void addListeners() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the text only when the button is clicked
                text2.setText("<html>" + customer.gettranshistory() + "</html>");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tr.dispose();
                new home(customer);
            }
        });
    }
}
