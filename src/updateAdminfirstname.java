import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateAdminfirstname extends JFrame {
    private JTextField firsfield;
    private JButton submitButton;
    private JButton clearButton;
    private JPanel panel;
public updateAdminfirstname(Connection connection,int adminID) {
    setContentPane(panel);
    setTitle("update admin first name");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String newname = firsfield.getText();
            PreparedStatement statement;
            String sql;
            sql = "UPDATE Admin set firstName = ? where AdminID = ?";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, newname);
                statement.setInt(2,adminID);
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
            firsfield.setText("");
        }
    });
}
}
