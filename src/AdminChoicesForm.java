import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AdminChoicesForm extends JFrame
{
    private JButton addATrainButton;
    private JButton editATrainButton;
    private JButton addATripButton;
    private JButton editATripButton;
    private JButton deleteATripButton;
    private JButton updateAnAdminSButton;
    private JPanel AdminChoicesForm;

    public AdminChoicesForm(Connection connection,int AdminID)
{
    setContentPane(AdminChoicesForm);
    setTitle("Admin Choices List");
    setSize(450,300);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    addATrainButton.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    editATrainButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    addATripButton.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            TripForm AddaTripForm = new TripForm(connection);
            AddaTripForm.setVisible(true);
        }
    });
    editATripButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    deleteATripButton.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            DeleteaTripForm DelaTripForm = new DeleteaTripForm(connection);
            DelaTripForm.setVisible(true);
        }
    });
    updateAnAdminSButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update_admin_info DelaTripForm = new update_admin_info(connection,AdminID);
            DelaTripForm.setVisible(true);
        }
    });
}
}
