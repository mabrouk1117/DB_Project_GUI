import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
public class Booking  extends JFrame {
    private JTextField tripId;
    private JButton BOOKTheTripButton;
    private JButton clear;
    private JPanel BookingForm;
public Booking( Connection connection , int customerId) {
    setContentPane(BookingForm) ;
    setTitle("book a trip");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    BOOKTheTripButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            customer myCustomer = new customer(connection) ;
            int TripID=Integer.parseInt(tripId.getText());
            myCustomer.Booking(TripID ,customerId);
        }
    });
    clear.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tripId.setText("");
        }
    });
}
}
