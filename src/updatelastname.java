import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updatelastname extends JFrame{
    private JPanel panel1;
    private JTextField lastfield;
    private JButton submitButton;
    private JButton clearButton;
public updatelastname(Connection connection,int customerID) {
    setContentPane(panel1);
    setTitle("update customer last name");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = lastfield.getText();
            PreparedStatement statement;
            String sql;
            sql = "UPDATE Customer set lastName = ? where CustomerID = ?";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, name);
                statement.setInt(2, customerID);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null," last name changed successfully ");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }
    });
    clearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            lastfield.setText("");
        }
    });
}
}
