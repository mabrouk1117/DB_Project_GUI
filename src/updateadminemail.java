import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateadminemail extends JFrame {
    private JTextField mailfield;
    private JButton submitButton;
    private JButton clearButton;
    private JPanel panel;
public updateadminemail(Connection connection,int adminID) {
    setContentPane(panel);
    setTitle("update admin email");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = mailfield.getText();
            PreparedStatement statement;
            String sql;
            sql = "UPDATE Admin set Email = ? where AdminID = ?";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, name);
                statement.setInt(2,adminID);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null," email changed successfully ");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
    clearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            mailfield.setText("");
        }
    });
}
}
