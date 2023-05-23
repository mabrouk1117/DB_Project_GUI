import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class LoginAdminForm extends JFrame {
    private JPanel LoginAdminForm;
    private JTextField tfID;
    private JTextField tfpass;
    private JButton logInAsAnButton;
    private JButton clearButton;
public LoginAdminForm(logIn myAdmin, Connection connection)
{
    setContentPane(LoginAdminForm);
    setTitle("Log-In as an Admin");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    logInAsAnButton.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int id = Integer.parseInt(tfID.getText());
            String passwordInput = tfpass.getText();
            int successfull_login= myAdmin.loginAdmin(id,passwordInput);
            if (successfull_login!=-1)
            {
                AdminChoicesForm choicesForm = new AdminChoicesForm(connection);
                choicesForm.setVisible(true);
            }

        }
    });
    clearButton.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            tfpass.setText("");
            tfID.setText("");
        }
    });
}
}
