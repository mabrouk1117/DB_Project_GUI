import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class update_info_costumer extends JFrame {
    private JButton editFirstNameButton;
    private JButton editLastNameButton;
    private JButton editPhoneNumberButton;
    private JButton editPasswordButton;
    private JButton editEmailButton;
    private JButton returnToMainMenuButton;
    private JPanel updateinfocustomer;

    public update_info_costumer(Connection connection,int customerID) {
        setContentPane(updateinfocustomer);
        setTitle("update customer info list");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    editFirstNameButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updatecustomerfirstname AddaTrainForm = new updatecustomerfirstname(connection,customerID);
            AddaTrainForm.setVisible(true);

        }
    });
    editLastNameButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updatelastname AddaTrainForm = new updatelastname(connection,customerID);
            AddaTrainForm.setVisible(true);

        }
    });
    editPhoneNumberButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updatephone AddaTrainForm = new updatephone(connection,customerID);
            AddaTrainForm.setVisible(true);
        }
    });
    editPasswordButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updatepassword AddaTrainForm = new updatepassword(connection,customerID);
            AddaTrainForm.setVisible(true);
        }
    });
    editEmailButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updatemail AddaTrainForm = new updatemail(connection,customerID);
            AddaTrainForm.setVisible(true);
        }
    });
    returnToMainMenuButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            CustomerChoicesForm AddaTrainForm = new CustomerChoicesForm(connection,customerID);
            AddaTrainForm.setVisible(true);
        }
    });
}
}
