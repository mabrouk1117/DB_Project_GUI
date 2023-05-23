//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.Scanner;
//import java.util.regex.Pattern;
//
//public class Customer
//{
//    private String fname;
//    private String lname;
//    private String email;
//    private String phone;
//    private String password;
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public Customer(){}
//    public  boolean validate_fname(String FN)
//    {
//        boolean val3=true;
//        while (val3)
//        {
//            boolean Name_validate= Pattern.matches("^([A-Za-z]+) {3,50}$",FN);
//            if (Name_validate)
//            {
//                fname=FN;
//                val3=false;
//            }
//            else
//            {
//                System.out.println("Invalid Username, rules of a username Name MUST consists of two partitions (ie: first and second name) saparated by a SINGLE space and the first letter of every part MUST be capital");
//                System.out.println("Enter again your Username:");
//                FN=new Scanner(System.in).nextLine();
//            }
//        }
//        return true;
//    }
//
//    public  boolean validate_lname(String LN)
//    {
//        boolean val3=true;
//        while (val3)
//        {
//            boolean Name_validate= Pattern.matches("^([A-Za-z]+) {3,50}$",LN);
//            if (Name_validate)
//            {
//                lname=LN;
//                val3=false;
//            }
//            else
//            {
//                System.out.println("Invalid Username, rules of a username Name MUST consists of two partitions (ie: first and second name) saparated by a SINGLE space and the first letter of every part MUST be capital");
//                System.out.println("Enter again your Username:");
//                LN=new Scanner(System.in).nextLine();
//            }
//        }
//        return true;
//    }
//
//    public boolean validate_email(String E)
//    {
//        boolean val2=true;
//        while (val2)
//        {
//            boolean email_validate= Pattern.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]+$",E);
//            if (email_validate)
//            {    email=E;
//                val2=false;
//            }
//            else
//            {
//                System.out.println("Invalid Email,please Enter again your email:");
//                E=new Scanner(System.in).nextLine();
//            }
//        }
//        return true;
//    }
//    public boolean validate_pass(String pass)
//    {
//        boolean val=true;
//        while (val)
//        {
//            boolean pass_validate= Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&_*]).{8,}",pass);
//            if (pass_validate)
//            {
//                password=pass;
//                val=false;
//            }
//            else
//            {
//                System.out.println("Invalid Password, rules of a password:\n 1- At least 8 chars\n 2- has at least one symbol\n 3- has at least one number\n 4- has at least one uppercase letter\n 5- has at least one lowercase letter ");
//                System.out.println("Enter again your password:");
//                pass=new Scanner(System.in).nextLine();
//            }
//        }
//        return true;
//    }
//
//    public boolean validate_phone(String ph)
//    {
//        boolean val5=true;
//        while (val5)
//        {
//            boolean phone_validate= Pattern.matches("(010|012|011|015)\\d{8}",ph);
//            if (phone_validate)
//            {    phone=ph;
//                val5=false;
//            }
//            else
//            {
//                System.out.println("Invalid phone number, rules of a phone number: it MUST starts with 010 or 012 or 011 or 015 then followed by 8 numbers only");
//                System.out.println("Enter again your phone number:");
//                ph=new Scanner(System.in).nextLine();
//            }
//        }
//        return true;
//    }
//
//    public void SignUp_Admin()
//    {
//        String url = "jdbc:mysql://localhost:3306/TrainTrip";
//        String username = "root";
//        String password = "ShroukMySQL2025#";
//        try
//        {
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            String sql = "INSERT INTO Admin (AdminID, FName, LName, PhoneNumber, Email, AdminPassword) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//
//            Scanner scanner = new Scanner(System.in);
//
//            boolean check=true;
//            System.out.print("Please enter enter you trip's ID: ");
//            while (check)
//            {
//                int tripID = scanner.nextInt();
//                if (tripID>0)
//                {
//                    statement.setInt(1, tripID);
//                    check=false;
//                }
//                else
//                {
//                    System.out.print("Invalid ID; ID MUST be Positive,Please enter again your Trip ID: ");
//                    continue;
//                }
//            }
//
//
//            while (check)
//            {
//                System.out.print("Please enter enter your Train's ID: ");
//                int trainID = scanner.nextInt();
//                if (trainID>0)
//                {
//                    statement.setInt(2, trainID);
//                    check=false;
//                }
//                else
//                {
//                    System.out.print("Invalid ID; ID MUST be Positive,Please enter again your train's ID: ");
//                    continue;
//                }
//            }
//
//
//            System.out.print("Enter Origin Station: ");
//            String origin = scanner.nextLine();
//            statement.setString(3, origin);
//
//            System.out.print("Enter Destination Station: ");
//            String destination = scanner.nextLine();
//            statement.setString(4, destination);
//
//            System.out.print("Enter Departure Date and Time (YYYY-MM-DD HH:mm:ss): ");
//            String departureDateTime = scanner.nextLine();
//            Timestamp departureTimestamp = Timestamp.valueOf(departureDateTime);
//            statement.setTimestamp(5, departureTimestamp);
//
//            System.out.print("Enter Arrival Date and Time (YYYY-MM-DD HH:mm:ss): ");
//            String arrivalDateTime = scanner.nextLine();
//            Timestamp arrivalTimestamp = Timestamp.valueOf(arrivalDateTime);
//            statement.setTimestamp(6, arrivalTimestamp);
//
//            System.out.print("Enter Available Seats: ");
//            int availableSeats = scanner.nextInt();
//            statement.setInt(7, availableSeats);
//
//            int rowsInserted = statement.executeUpdate();
//
//            if (rowsInserted > 0) {
//                System.out.println("Row inserted successfully!");
//            } else {
//                System.out.println("Failed to insert row.");
//            }
//
//            statement.close();
//            connection.close();
//            scanner.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//





import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class customer {
    private Connection connection;
    customer(Connection connection){
        this.connection = connection;
    }

    public String[] viewTrips(int customerID){
        String str="trip ID   origin Station   destination Station   departure Date   arrival Date   available Seats   trainName";

        String sql = "SELECT TripID, originStation, DestinationStation, DepartureDate, arrivalDate , availableSeats, trainName";
        sql += " FROM Trip join Train  on Trip.TrainID = Train.trainID where availableSeats != 0  ";
        try {
            List<String> stringList = new ArrayList<>();
            stringList.add(str);

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

                String s = Integer.toString(tripId) + "        "  + originStation + "                          " +destinationStation +"         "+ departureDate.toString() + "        " +  arrivalDate.toString()+ "        " + Integer.toString( availableSeats) + "        " +  trainName ;
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

    public void Booking(int customerID , Scanner scanner ){
        System.out.println("enter the trip id to book");
        int tripID = scanner.nextInt();
        scanner.nextLine();
        try {

            String sql = "SELECT availableSeats FROM Trip WHERE tripID = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, tripID);
            ResultSet resultSet = statement.executeQuery();

            if ( !(resultSet.next()) ) {
                System.out.println("the trip you're trying to book is not available ");
                statement.close();
                resultSet.close();
                return;
            }
            int availableSeats = resultSet.getInt("availableSeats");
            if (availableSeats == 0){
                System.out.println("the trip you're trying to book is not available ");
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
            System.out.println("you have booked successfully");
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
            System.out.println("your seat number is " + seatNumber );
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
    public void cancel(int customerId , Scanner scanner){
        System.out.println("enter your trip id ");
        int tripId = scanner.nextInt() ;
        scanner.nextLine() ;
        int numberOfBooks  ;
        try {
            String sql = "delete from Booking where CustomerID = ? and tripID = ?  ";
            PreparedStatement statement = connection.prepareStatement(sql) ;
            statement.setInt(1, customerId) ;
            statement.setInt(2, tripId) ;
            numberOfBooks =  statement.executeUpdate() ;
            if (numberOfBooks == 0 ){
                System.out.println("Either you didn't book this Trip previously Or it's an Invalid trip ID") ;
                statement.close() ;
                return;
            }
            System.out.println("Trip Cancellation Was Done Successfully") ;
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