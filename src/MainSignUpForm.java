import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class MainSignUpForm extends JFrame  {
    private JButton signUpAsAButton;
    private JButton signUpAsAnButton;
    private JPanel MainSignUpForm;
    public MainSignUpForm(Connection connection)
    {
        setContentPane(MainSignUpForm);
        setTitle("Welcome to our System");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        signUpAsAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp sign = new SignUp(connection);
                SignUpCustomer CustomerForm = new SignUpCustomer(sign);
//                sign.insertCustomer(CustomerForm);
            }
        });
        signUpAsAnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp sign = new SignUp(connection);
                SignUpAdminForm AdminForm= new SignUpAdminForm(sign);
            }
        });
    }
}
