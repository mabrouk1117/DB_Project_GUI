import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpCustomer extends JFrame{
    public JTextField tfFName;
    public JTextField tfLName;
    public JTextField tfPhoneNumber;
    public JTextField tfEmail;
    public JPasswordField passwordField1;
    public JPanel CustomerPanel;
    public JTextField tfID;
    public JButton signUpAsAUserButton;
    public JButton clearButton;
    public SignUpCustomer( SignUp myCustomer)
    {
        setContentPane(CustomerPanel);
        setTitle("Sign-Up as a Customer");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
//        SignUpCustomer CustomerForm=new SignUpCustomer();
        signUpAsAUserButton.addActionListener(new ActionListener()
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
                myCustomer.insertCustomer(id,firstName,lastName,phoneNumber,email,passwordInput);
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



