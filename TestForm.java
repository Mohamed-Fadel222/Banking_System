import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestForm extends JFrame implements ActionListener{


    JFrame frame = new JFrame();

   TestForm()
   {
       frame.setSize(420,540);
       frame.setVisible(true);
       frame.setContentPane(TEST);
   }
    private JButton button1;
    private JTextField textField1;
    private JPanel TEST;


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
