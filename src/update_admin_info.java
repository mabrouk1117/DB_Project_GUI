import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class update_admin_info extends JFrame {
    private JButton editFirstNameButton;
    private JButton editLastNameButton;
    private JButton editPhoneNumberButton;
    private JButton editPasswordButton;
    private JButton editEmailButton;
    private JButton returnToMainMenuButton;
    private JPanel updateadmin;
public update_admin_info(Connection connection,int adminID) {
    setContentPane(updateadmin);
    setTitle("update customer info list");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    editFirstNameButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateAdminfirstname AddaTrainForm = new updateAdminfirstname(connection,adminID);
            AddaTrainForm.setVisible(true);
        }
    });
    editLastNameButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateAdminlastname AddaTrainForm = new updateAdminlastname(connection,adminID);
            AddaTrainForm.setVisible(true);
        }
    });
    editPhoneNumberButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateadminphone AddaTrainForm = new updateadminphone(connection,adminID);
            AddaTrainForm.setVisible(true);
        }
    });
    editPasswordButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateAdminpass AddaTrainForm = new updateAdminpass(connection,adminID);
            AddaTrainForm.setVisible(true);
        }
    });
    editEmailButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateadminemail AddaTrainForm = new updateadminemail(connection,adminID);
            AddaTrainForm.setVisible(true);

        }
    });
    returnToMainMenuButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AdminChoicesForm AddaTrainForm = new AdminChoicesForm(connection,adminID);
            AddaTrainForm.setVisible(true);
        }
    });
}
}
