import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updatephone extends JFrame {
    private JTextField phonefield;
    private JButton submitButton;
    private JButton clearButton;
    private JPanel panel2;

    public updatephone(Connection connection,int customerID) {
    setContentPane(panel2);
    setTitle("update customer phone number");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = phonefield.getText();
            PreparedStatement statement;
            String sql;
            sql = "UPDATE Customer set phoneNumber = ? where CustomerID = ?";
            try {
                statement = connection.prepareStatement(sql);
                statement.setString(1, name);
                statement.setInt(2, customerID);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null," phone number changed successfully");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    });
    clearButton.addComponentListener(new ComponentAdapter() {
    });
    clearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            phonefield.setText("");
        }
    });
}
}
