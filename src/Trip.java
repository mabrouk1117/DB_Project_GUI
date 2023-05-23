


import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

public class Trip
{
    private Connection connection;

    public Trip(Connection connection) {
        this.connection = connection;
    }

    private boolean isTripIDValid(int TripID) throws SQLException {
        String sql = "SELECT TripID FROM Trip WHERE TripID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, TripID);
        ResultSet resultSet = statement.executeQuery();
        boolean isValid = resultSet.next();
        resultSet.close();
        statement.close();
        return isValid;
    }

    private boolean isTrainIDValid(int trainID) throws SQLException {
        String sql = "SELECT TrainID FROM Train WHERE TrainID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, trainID);
        ResultSet resultSet = statement.executeQuery();
        boolean isValid = resultSet.next();
        resultSet.close();
        statement.close();
        return isValid;
    }


    private int getNumOfSeats(int trainID) throws SQLException {
        String sql = "SELECT numberOfSeats FROM Train WHERE TrainID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, trainID);
        ResultSet resultSet = statement.executeQuery();
        int numOfSeats = 0;
        if (resultSet.next()) {
            numOfSeats = resultSet.getInt("numberOfSeats");
        }
        resultSet.close();
        statement.close();
        return numOfSeats;
    }
    private void insertTrain(int trainID) throws SQLException {
        String sql = "INSERT INTO Train (TrainID) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, trainID);
        statement.executeUpdate();
        statement.close();
    }


    private int TripSeats(int tripID) throws SQLException {
        String sql = "SELECT trainID FROM Trip WHERE tripID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, tripID);
        ResultSet resultSet = statement.executeQuery();

        int trainID = 0; // Initialize the variable to hold the number of seats

        if (resultSet.next()) {
            trainID = resultSet.getInt("trainID"); // Get the value from the resultSet
        }
        resultSet.close();
        statement.close();
        int TrainSeats= getNumOfSeats(trainID);

        return TrainSeats;
    }

    public void Add_a_Trip(int tripID,int trainID,String origin, String destination, String departureDateTime,String arrivalDateTime,int availableSeats,int AdminID)
    {
        int GlobalTripID=0,GlobalTrainID=0;
        String GlobalOriginSt,GlobalDestSt;
        Timestamp GlobalDepDate,GlobalArrivalDate;
        try {
            String sql = "INSERT INTO Trip (TripID, TrainID, originStation, DestinationStation, DepartureDate, arrivalDate, availableSeats , adminID) VALUES (?, ?, ?, ?, ?, ?, ? ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            if (tripID > 0)
            {
                if(!isTripIDValid(tripID))
                {
                    statement.setInt(1, tripID);
                    GlobalTripID=tripID;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Trip Id id already used ");
                }
            } else {
                JOptionPane.showMessageDialog(null,"Invalid ID; ID MUST be Positive,Please enter again your Trip ID: ");
            }

            if (trainID > 0) {
                if (!isTrainIDValid(trainID))
                {
                    JOptionPane.showMessageDialog(null,"Invalid ID; this Train ID does NOT belong to our system, ");
                } else {
                    statement.setInt(2, trainID);
                    GlobalTrainID=trainID;
                }
            } else {
                JOptionPane.showMessageDialog(null,"Invalid ID; ID MUST be Positive,Please enter again your Train ID: ");
            }

            statement.setString(3, origin);
            GlobalOriginSt=origin;

            statement.setString(4, destination);
            GlobalDestSt=destination;


            Timestamp departureTimestamp = Timestamp.valueOf(departureDateTime);
            statement.setTimestamp(5, departureTimestamp);
            GlobalDepDate=departureTimestamp;

            Timestamp arrivalTimestamp = Timestamp.valueOf(arrivalDateTime);

            LocalDate departureDate = departureTimestamp.toLocalDateTime().toLocalDate();
            LocalDate arrivalDate = arrivalTimestamp.toLocalDateTime().toLocalDate();

            if (arrivalDate.isBefore(departureDate)) {
                JOptionPane.showMessageDialog(null,"Invalid arrival date. Arrival date MUST be on OR after the departure date. Please enter again.");

            }
            LocalTime departureTime = departureTimestamp.toLocalDateTime().toLocalTime();
            LocalTime arrivalTime = arrivalTimestamp.toLocalDateTime().toLocalTime();

            if (arrivalDate.isEqual(departureDate) && (arrivalTime.isBefore(departureTime) || arrivalTime.equals(departureTime))) {
                JOptionPane.showMessageDialog(null,"Invalid arrival time. Arrival time MUST be after the departure time. Please enter again.");

            }

            statement.setTimestamp(6, arrivalTimestamp);
            GlobalArrivalDate=arrivalTimestamp;



                if (availableSeats>0)
                {
                    if (availableSeats>getNumOfSeats(GlobalTrainID))
                    {
                        JOptionPane.showMessageDialog(null,"your train can't hold this number of seats, your train has  Only " + getNumOfSeats(GlobalTrainID) + " Seats");
                    }
                    else if (availableSeats<=getNumOfSeats(GlobalTrainID))
                    {
                        statement.setInt(7, availableSeats);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Number of Seats; Number of Seats MUST be Positive,Please enter again your Trip  Number of Seats: ");
                }

            statement.setInt(8,AdminID);
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null,"Trip added successfully!");
            } else {
                JOptionPane.showMessageDialog(null,"Failed to add the Trip.");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Edit_a_Trip(int TripId, int TrainId, String OriginStation, String DestStation, String Dept, String Arrival, int Seats, int Adminid) {
        try {
            if (isTrainIDValid(TrainId) && isTripIDValid(TripId)) {
                Timestamp departureTimestamp = Timestamp.valueOf(Dept);
                Timestamp arrivalTimestamp = Timestamp.valueOf(Arrival);

                LocalDate departureDate = departureTimestamp.toLocalDateTime().toLocalDate();
                LocalDate arrivalDate = arrivalTimestamp.toLocalDateTime().toLocalDate();
                LocalTime departureTime = departureTimestamp.toLocalDateTime().toLocalTime();
                LocalTime arrivalTime = arrivalTimestamp.toLocalDateTime().toLocalTime();

                if (arrivalDate.isBefore(departureDate)) {
                    JOptionPane.showMessageDialog(null, "Invalid arrival date. Arrival date MUST be on or after the departure date. Please enter again.");
                    return;
                }

                if (arrivalDate.isEqual(departureDate) && (arrivalTime.isBefore(departureTime) || arrivalTime.equals(departureTime))) {
                    JOptionPane.showMessageDialog(null, "Invalid arrival time. Arrival time MUST be after the departure time. Please enter again.");
                    return;
                }
                if (Seats>getNumOfSeats(TrainId))
                {
                    JOptionPane.showMessageDialog(null,"your train can't hold this number of seats, your train has  Only " + getNumOfSeats(TrainId) + " Seats");
                    return;
                }


                String sql = "UPDATE trip SET trainID = ?, originStation = ?, destinationStation = ?, DepartureDate = ?, arrivalDate = ?, availableSeats = ?, adminID = ? WHERE tripID = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, TrainId);
                statement.setString(2, OriginStation);
                statement.setString(3, DestStation);
                statement.setTimestamp(4, departureTimestamp);
                statement.setTimestamp(5, arrivalTimestamp);
                statement.setInt(6, Seats);
                statement.setInt(7, Adminid);
                statement.setInt(8, TripId);

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Trip updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update the Trip.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Invalid ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete_a_trip(int DesiredTripID )
    {
        try
        {
            if (isTripIDValid(DesiredTripID))
            {
                String sql = "DELETE FROM Trip WHERE TripID = ?";
                PreparedStatement statement2 = connection.prepareStatement(sql);
                statement2.setInt(1, DesiredTripID);
                statement2.executeUpdate();
                statement2.close();
                JOptionPane.showMessageDialog(null,"Your Trip was Deleted Successfully " );
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid TripID; This ID doesn't exist on our System");
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
