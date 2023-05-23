import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Canellation extends JFrame {
    private JButton cancelButton;
    private JButton clearButton;
    private JTextField tripId;
    private JPanel cancellationForm;

    public Canellation(Connection connection , int customerId) {

        setContentPane(cancellationForm) ;
        setTitle("cancel a booking");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            customer myCustomer = new customer(connection) ;
            int TripID=Integer.parseInt(tripId.getText());
            myCustomer.cancel(TripID ,customerId) ;
        }
    });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tripId.setText("");

            }
        });
    }
}
