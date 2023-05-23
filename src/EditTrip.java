import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class EditTrip extends JFrame{
    private JTextField TripID;
    private JTextField TrainID;
    private JTextField OrginStation;
    private JTextField DestinationStation;
    private JLabel OriginStation;
    private JTextField ArrivalDate;
    private JButton saveButton;
    private JPanel EditTrip;
    private JTextField DepatureDate;
    private JTextField AvailableSeats;

    public EditTrip(Connection connection, int Adminid) {
    setContentPane(EditTrip);
    setTitle("Update Trip");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Trip myTrip = new Trip(connection);
                int TripId=Integer.parseInt(TripID.getText());
                int TrainId=Integer.parseInt(TrainID.getText());
                String OriginStation=OrginStation.getText();
                String DestStation=DestinationStation.getText();
                String Dept= DepatureDate.getText();
                String Arrival=ArrivalDate.getText();
                int Seats=Integer.parseInt(AvailableSeats.getText());
                myTrip.Edit_a_Trip(TripId,TrainId,OriginStation,DestStation,Dept,Arrival,Seats,Adminid);
                dispose();
            }
        });
    }
}
