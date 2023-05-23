import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class LogInCustomerForm  extends JFrame{
    private JTextField tfID;
    private JTextField tfpass;
    private JPanel LogInCustomerForm;
    private JButton logInAsAButton;
    private JButton clearButton;
public LogInCustomerForm(logIn myCustomer, Connection connection)
{
    setContentPane(LogInCustomerForm);
    setTitle("Log-In as a Customer");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    logInAsAButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int id = Integer.parseInt(tfID.getText());
            String passwordInput = tfpass.getText();
            int successfull_login = myCustomer.loginCustomer(id,passwordInput);
            if (successfull_login!=-1)
            {
                CustomerChoicesForm choicesForm = new CustomerChoicesForm(connection,id);
                choicesForm.setVisible(true);
            }
        }
    });
    clearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tfpass.setText("");
            tfID.setText("");
        }
    });
}
}
