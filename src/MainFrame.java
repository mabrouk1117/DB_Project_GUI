import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class MainFrame extends JFrame {
    private JPanel MainFrame;
    private JButton logiInButton;
    private JButton signUpButton;

    public MainFrame(Connection connection)
    {
        setContentPane(MainFrame);
        setTitle("Welcome To Our Booking Train System");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        logiInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainLogInForm logInForm = new MainLogInForm(connection);
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                MainSignUpForm signUpForm = new MainSignUpForm(connection);
            }
        });
    }

}
