import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.sql.Connection;

public class TripForm extends JFrame {
    private JTextField tfTripID;
    private JTextField tfTrainID;
    private JTextField tfDept;
    private JTextField tfArrivalDate;
    private JTextField tfSeats;
    private JButton saveTripToOurButton;
    private JButton clearButton;
    private JPanel TripForm;
    private JTextField origin;
    private JTextField dest;

    public TripForm(Connection connection)
    {
        setContentPane(TripForm);
        setTitle("Add a New Trip To Our System");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        saveTripToOurButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Trip MyTrip= new Trip(connection);
                int TripID=Integer.parseInt(tfTripID.getText());
                int TrainID=Integer.parseInt(tfTrainID.getText());
                String OriginStation=origin.getText();
                String DestStation=dest.getText();
                String Dept= tfDept.getText();
                String Arrival=tfArrivalDate.getText();
                int Seats=Integer.parseInt(tfSeats.getText());
                int AdminID=Integer.parseInt(tfSeats.getText());  ///THIS ATTRIBUTE IS WRONGGGGG
                MyTrip.Add_a_Trip(TripID,TrainID,OriginStation,DestStation,Dept,Arrival,Seats,AdminID);

            }
        });
        clearButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tfTripID.setText("");
                tfTrainID.setText("");
                tfDept.setText("");
                tfSeats.setText("");
                origin.setText("");
                dest.setText("");
                tfArrivalDate.setText("");
            }
        });
    }
}
