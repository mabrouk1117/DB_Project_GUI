import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class CustomerChoicesForm extends JFrame
{
    private JButton viewAvailableTripsButton;
    private JButton bookATripButton;
    private JButton cancelATripButton;
    private JButton updateUserSInformationButton;
    private JPanel CustomerChoicesForm;

    public CustomerChoicesForm(Connection connection , int customerID)
  {
    setContentPane(CustomerChoicesForm);
    setTitle("Customer Choices List");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    viewAvailableTripsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            temp t = new temp();
            customer c = new customer(connection) ;
            c.viewTrips(customerID) ;
            t.run(c.viewTrips(customerID));
        }
    });
    bookATripButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        Booking b = new Booking(connection , customerID);
        b.setVisible(true);
        }
    });
    cancelATripButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Canellation c = new Canellation(connection , customerID );
            c.setVisible(true);
        }
    });
    updateUserSInformationButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update_info_costumer AddaTrainForm = new update_info_costumer(connection,customerID);
            AddaTrainForm.setVisible(true);
        }
    });
  }
}
