import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class MainLogInForm extends JFrame {
    private JButton logInAsAButton;
    private JButton logInAsAnButton;
    private JPanel MainLogInForm;

    public MainLogInForm(Connection connection)
    {
        setContentPane(MainLogInForm);
        setTitle("Welcome Back to Our System");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        logInAsAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logIn loginObj = new logIn(connection);
                LogInCustomerForm CustomerForm = new LogInCustomerForm(loginObj,connection);
            }
        });
        logInAsAnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logIn loginObj = new logIn(connection);
                LoginAdminForm AdminForm = new LoginAdminForm(loginObj,connection);
            }
        });
    }
}
