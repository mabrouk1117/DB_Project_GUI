import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updatepassword extends JFrame {
    private JTextField passfield;
    private JPanel panel3;
    private JButton submitButton;
    private JButton clearButton;
public updatepassword(Connection connection,int customerID) {
    setContentPane(panel3);
    setTitle("update customer password");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = passfield.getText();
            PreparedStatement statement;
            String sql;
            sql = "UPDATE Customer set password = ? where CustomerID = ?";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, name);
                statement.setInt(2, customerID);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null," password changed successfully");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    });
    clearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}
}
