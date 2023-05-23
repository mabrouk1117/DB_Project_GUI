import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class DeleteaTripForm extends JFrame
{
    private JTextField tfTripID;
    private JButton deleteTheTripButton;
    private JButton clearButton;
    private JPanel DeleteaTripForm;
    public DeleteaTripForm(Connection connection)
    {
        setContentPane(DeleteaTripForm);
        setTitle("Delete A Trip From Our System");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        deleteTheTripButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Trip MyTrip= new Trip(connection);
                int DesiredTripID=Integer.parseInt(tfTripID.getText());
                MyTrip.delete_a_trip(DesiredTripID);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tfTripID.setText("");
            }
        });
    }
}
