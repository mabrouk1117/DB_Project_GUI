//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.Scanner;
//import java.util.regex.Pattern;
//
//public class Admin
//{
//    private String fname;
//    private String lname;
//    private String email;
//    private String phone;
//    private String password;
//    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public Admin(){}
//    /**
//     * this function is for name validation
//     * @param N
//     * @return boolean
//     */
//    public  boolean validate_name(String N)
//    {
//        boolean val3=true;
//        while (val3)
//        {
//            boolean Name_validate= Pattern.matches("^([A-Za-z]+)\\s([A-Za-z]+)$",N);
//            if (Name_validate)
//            {
//                name=N;
//                val3=false;
//            }
//            else
//            {
//                System.out.println("Invalid Username, rules of a username Name MUST consists of two partitions (ie: first and second name) saparated by a SINGLE space and the first letter of every part MUST be capital");
//                System.out.println("Enter again your Username:");
//                N=new Scanner(System.in).nextLine();
//            }
//        }
//        return true;
//    }
//    /**
//     * this function is for email validation
//     * @param E
//     * @return boolean
//     */
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
//    /**
//     * this function is for password validation
//     * @param pass
//     * @return boolean
//     */
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
//    /**
//     * this function is for phone validation
//     * @param ph
//     * @return boolean
//     */
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
//    }
//    public void SignIn_Admin()
//    {
//
//    }
//}
