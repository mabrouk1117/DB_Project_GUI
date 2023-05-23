import javax.swing.*;

public class temp {
    temp(){}
    public void run( String[] listData) {
        // Create a new JFrame
        JFrame frame = new JFrame("List Label Example");

        // Create a list

        JList<String> list = new JList<>(listData);

        // Create a label for the list
        JLabel label = new JLabel("available trips: ");
        label.setLabelFor(list);

        // Create a panel to hold the list and label
        JPanel panel = new JPanel();

        panel.add(label);
        panel.add(list);

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // Set the size and visibility of the frame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
