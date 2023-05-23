import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updatecustomerfirstname extends JFrame{
    private JPanel firstname;
    private JTextField firstfield;
    private JButton sumbitButton;
    private JButton clearButton;
public updatecustomerfirstname(Connection connection,int customerID) {
    setContentPane(firstname);
    setTitle("update customer first name");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    sumbitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String newname = firstfield.getText();
            PreparedStatement statement;
            String sql;
            sql = "UPDATE Customer set firstName = ? where CustomerID = ?";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, newname);
                statement.setInt(2,customerID);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null," first name changed successfully");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
    clearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            firstfield.setText("");
        }
    });
}
}
