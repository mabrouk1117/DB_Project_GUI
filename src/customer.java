import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class customer {
    private Connection connection;
    customer(Connection connection){
        this.connection = connection;
    }

    public String[] viewTrips(int customerID){

        String sql = "SELECT TripID, originStation, DestinationStation, DepartureDate, arrivalDate , availableSeats, trainName";
        sql += " FROM Trip join Train  on Trip.TrainID = Train.trainID where availableSeats != 0  ";
        try {
            List<String> stringList = new ArrayList<>();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int tripId = resultSet.getInt("TripID");
                String originStation = resultSet.getString("originStation");
                String destinationStation = resultSet.getString("DestinationStation");
                Timestamp departureDate = resultSet.getTimestamp("DepartureDate");
                Timestamp arrivalDate = resultSet.getTimestamp("arrivalDate");
                int availableSeats = resultSet.getInt("availableSeats");
                String trainName = resultSet.getString("trainName");

                // Process the retrieved data as needed
                String s = Integer.toString(tripId) + " "  + originStation + " " +destinationStation +"  "+ departureDate.toString() + " " +  arrivalDate.toString()+ " " + Integer.toString( availableSeats) + " " +  trainName ;
                stringList.add(s) ;
            }
            statement.close();
            resultSet.close();
            String[] stringArray = stringList.toArray(new String[stringList.size()]);
            return stringArray;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        String[] stringList2 = new String[0];
        return stringList2 ;
    }

    public void Booking( int tripID  ,int customerID ){

        try {
            String sql = "SELECT availableSeats FROM Trip WHERE tripID = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, tripID);
            ResultSet resultSet = statement.executeQuery();

            if ( !(resultSet.next()) ) {
                JOptionPane.showMessageDialog(null,"the trip you're trying to book is not available");

                statement.close();
                resultSet.close();
                return;
            }
            int availableSeats = resultSet.getInt("availableSeats");
            if (availableSeats == 0){
                JOptionPane.showMessageDialog(null,"the trip you're trying to book is not available");

                statement.close();
                resultSet.close();
                return;
            }

            statement.close();
            resultSet.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        int bookingID  , seatNumber;

        try {
            String sql = "SELECT COUNT(BookingID) as nxtID FROM Booking";
            PreparedStatement statement = connection.prepareStatement(sql) ;
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                bookingID = resultSet.getInt("nxtID");
            }
            else
                bookingID = 0;
            statement.close();
            resultSet.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        try {
            String sql = "SELECT COUNT(BookingID) as nxtID FROM Booking where tripId = ?";
            PreparedStatement statement = connection.prepareStatement(sql) ;
            statement.setInt(1, tripID) ;
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                seatNumber = resultSet.getInt("nxtID") + 1;
            }
            else {
                seatNumber = 1 ;
            }
            statement.close();
            resultSet.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return ;
        }
        try {
            String sql = "insert into Booking(BookingID , CustomerID , tripID) values(? , ? , ?)" ;
            PreparedStatement statement = connection.prepareStatement(sql) ;
            statement.setInt(1, bookingID) ;
            statement.setInt(2, customerID) ;
            statement.setInt(3, tripID) ;
            int resultSet = statement.executeUpdate();
            JOptionPane.showMessageDialog(null,"you have booked successfully");

            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        try {
            String sql = "insert into BookingDetails(BookingID , seatNumber) values(? , ? )" ;
            PreparedStatement statement = connection.prepareStatement(sql) ;
            statement.setInt(1, bookingID) ;
            statement.setInt(2, seatNumber) ;
            int resultSet = statement.executeUpdate();
            String s = "your seat number is " + seatNumber ;
            JOptionPane.showMessageDialog(null,s);

            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        try {
            String sql = "update trip set availableSeats = availableSeats - 1 where tripID = ?" ;
            PreparedStatement statement = connection.prepareStatement(sql) ;
            statement.setInt(1, tripID) ;

            int resultSet = statement.executeUpdate();
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void cancel(int tripId , int customerId){

        int numberOfBooks  ;

        try {
            String sql = "delete from Booking where CustomerID = ? and tripID = ?  ";
            PreparedStatement statement = connection.prepareStatement(sql) ;
            statement.setInt(1, customerId) ;
            statement.setInt(2, tripId) ;
            numberOfBooks =  statement.executeUpdate() ;
            if (numberOfBooks == 0 ){
                JOptionPane.showMessageDialog(null,"Either you didn't book this Trip previously Or it's an Invalid trip ID");
                statement.close() ;
                return;
            }
            JOptionPane.showMessageDialog(null,"Trip Cancellation Was Done Successfully");
            statement.close() ;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        try {
            String sql = "update trip set availableSeats = (availableSeats + ?) where tripID = ?" ;
            PreparedStatement statement = connection.prepareStatement(sql) ;
            statement.setInt(1, numberOfBooks) ;
            statement.setInt(2, tripId ) ;

            int resultSet = statement.executeUpdate();
            statement.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}