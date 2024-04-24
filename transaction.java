import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaction {
    private JPanel trans;
    private JButton button1;
    private JLabel text2 ;
    private JPanel transpanel;
    private JButton button2;

    Customer customer;

    JFrame tr = new JFrame();



    public transaction(Customer customer) {

        this.customer = customer;

        tr.setSize(600, 600);
        tr.setVisible(true);
        tr.setContentPane(transpanel);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    text2.setText(customer.gettranshistory());

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