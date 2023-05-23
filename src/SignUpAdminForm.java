import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpAdminForm extends JFrame {
    public JPanel SignUpAdmin;
    public JTextField tfFName;
    public JTextField tfLName;
    public JTextField tfPhoneNumber;
    public JTextField tfEmail;
    public JPasswordField passwordField1;
    public JTextField tfID;
    public JButton signUpAsAnAdminButton;
    public JButton clearButton;
//    public SignUp myAdmin;

    public SignUpAdminForm(SignUp myAdmin)
    {
        setContentPane(SignUpAdmin);
        setTitle("Sign-Up as a Customer");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
//        SignUpAdminForm AdminForm=new SignUpAdminForm();
        signUpAsAnAdminButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int id = Integer.parseInt(tfID.getText());
                String firstName = tfFName.getText();
                String lastName = tfLName.getText();
                String phoneNumber =tfPhoneNumber.getText();
                String email =tfEmail.getText();
                String passwordInput = passwordField1.getText();
                myAdmin.insertAdmin(id,firstName,lastName,phoneNumber,email,passwordInput);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfFName.setText("");
                tfLName.setText("");
                tfPhoneNumber.setText("");
                tfEmail.setText("");
                passwordField1.setText("");
                tfID.setText("");
            }
        });
    }
}
