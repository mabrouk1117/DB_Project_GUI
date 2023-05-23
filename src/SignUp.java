//import java.sql.*;
//import java.util.Scanner;
//
//public class SignUp {
//    private Connection connection;
//
//    public SignUp(Connection connection) {
//        this.connection = connection;
//    }
//
//    public void insertCustomer(Scanner scanner) {
//        try {
//            System.out.println("Enter the ID:");
//            int id = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.println("Enter the first name:");
//            String firstName = scanner.nextLine();
//
//            System.out.println("Enter the last name:");
//            String lastName = scanner.nextLine();
//
//            System.out.println("Enter the PhoneNumber :");
//            String phoneNumber = scanner.nextLine();
//
//            System.out.println("Enter the email:");
//            String email = scanner.nextLine();
//
//            System.out.println("Enter the password:");
//            String passwordInput = scanner.nextLine();
//
//            String sql = "INSERT INTO Customer (CustomerID, firstName, lastName, phoneNumber, Email, password) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
//            statement.setString(2, firstName);
//            statement.setString(3, lastName);
//            statement.setString(4, phoneNumber);
//            statement.setString(5, email);
//            statement.setString(6, passwordInput);
//
//            int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("Data inserted successfully.");
//            } else {
//                System.out.println("Failed to insert data.");
//            }
//
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public void insertAdmin(Scanner scanner) {
//        try {
//            System.out.println("Enter the ID:");
//            int id = scanner.nextInt();
//            scanner.nextLine();
//
//            System.out.println("Enter the first name:");
//            String firstName = scanner.nextLine();
//
//            System.out.println("Enter the last name:");
//            String lastName = scanner.nextLine();
//
//            System.out.println("Enter the PhoneNumber :");
//            String phoneNumber = scanner.nextLine();
//
//            System.out.println("Enter the email:");
//            String email = scanner.nextLine();
//
//            System.out.println("Enter the password:");
//            String passwordInput = scanner.nextLine();
//
//            String sql = "INSERT INTO Admin (AdminID, firstName, lastName, phoneNumber, Email, password) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, id);
//            statement.setString(2, firstName);
//            statement.setString(3, lastName);
//            statement.setString(4, phoneNumber);
//            statement.setString(5, email);
//            statement.setString(6, passwordInput);
//
//            int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("Data inserted successfully.");
//            } else {
//                System.out.println("Failed to insert data.");
//            }
//
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void closeConnection() {
//        try {
//            if (connection != null && !connection.isClosed()) {
//                connection.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}







import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;


public class SignUp {
    private Connection connection;

    public SignUp(Connection connection) {
        this.connection = connection;
    }
    private boolean isValidcustomerID(int ID) throws SQLException{
        if(ID<1000){
            System.out.println("please enter long ID");
            return true;
        }
        String sql = "SELECT CustomerID FROM customer Where CustomerID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,ID);
        ResultSet resultSet = statement.executeQuery();
        boolean res = resultSet.next();
        if(res==true){
            System.out.println("id exists already");
        }
        return res;
    }
    private boolean isValidadminID(int ID) throws SQLException{
        if(ID<1000){
            System.out.println("please enter long ID (greater than 1000)");
            return true;
        }
        String sql = "SELECT adminID FROM Admin Where adminID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,ID);
        ResultSet resultSet = statement.executeQuery();
        boolean res = resultSet.next();
        if(res==true){
            System.out.println("id exists already");
        }
        return res;
    }
    public void insertCustomer(int id,String firstName,String lastName,String phoneNumber,String email,String passwordInput)
    {
        try {
            String sql = "INSERT INTO Customer (CustomerID, firstName, lastName, phoneNumber, Email, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            if(isValidcustomerID(id)) {
                JOptionPane.showMessageDialog(null,"Invalid ID,This ID already Exists please enter a new one");
            }

                boolean fNameValidate = Pattern.matches("^[A-Za-z]{3,}$", firstName);
                if (fNameValidate)
                {
                    statement.setString(2, firstName);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid FirstName, be sure that the first letter of your name is a capital and that the name consists of AT LEAST 3 chars, also ONLY characters are valid");
                }
                boolean lNameValidate = Pattern.matches("^[A-Za-z]{3,}$", lastName);
                if (lNameValidate)
                {
                    statement.setString(3, lastName);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid LastName, be sure that the first letter of your name is a capital and that the name consists of AT LEAST 3 chars, also ONLY characters are valid");
                }
                boolean phone_validate= Pattern.matches("(010|012|011|015)\\d{8}",phoneNumber);
                if (phone_validate)
                {
                    statement.setString(4, phoneNumber);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid phone number, rules of a phone number: it MUST starts with 010 or 012 or 011 or 015 then followed by 8 numbers only");
                }
                boolean email_validate= Pattern.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]+$",email);
                if (email_validate)
                {
                    statement.setString(5, email);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Email, ");

                }

                boolean pass_validate= Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&_*]).{8,}",passwordInput);
                if (pass_validate)
                {
                    statement.setString(6, passwordInput);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Password, rules of a password:\n 1- At least 8 chars\n 2- has at least one symbol\n 3- has at least one number\n 4- has lowercase letters or uppercase letters or mix of them ,  ");
                }

            statement.setInt(1, id);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null,"Data inserted successfully.");
            } else {
                JOptionPane.showMessageDialog(null,"Failed to insert data.");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertAdmin(int id,String firstName,String lastName,String phoneNumber,String email,String passwordInput)
    {
        try {
            String sql = "INSERT INTO Admin (AdminID, firstName, lastName, phoneNumber, Email, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            if(isValidadminID(id)) {
                JOptionPane.showMessageDialog(null,"Invalid ID,This ID already Exists please enter a new one");
            }

            boolean fNameValidate = Pattern.matches("^[A-Za-z]{3,}$", firstName);
            if (fNameValidate)
            {
                statement.setString(2, firstName);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid FirstName, be sure that the first letter of your name is a capital and that the name consists of AT LEAST 3 chars, also ONLY characters are valid");
            }
            boolean lNameValidate = Pattern.matches("^[A-Za-z]{3,}$", lastName);
            if (lNameValidate)
            {
                statement.setString(3, lastName);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid LastName, be sure that the first letter of your name is a capital and that the name consists of AT LEAST 3 chars, also ONLY characters are valid");
            }
            boolean phone_validate= Pattern.matches("(010|012|011|015)\\d{8}",phoneNumber);
            if (phone_validate)
            {
                statement.setString(4, phoneNumber);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid phone number, rules of a phone number: it MUST starts with 010 or 012 or 011 or 015 then followed by 8 numbers only");
            }
            boolean email_validate= Pattern.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]+$",email);
            if (email_validate)
            {
                statement.setString(5, email);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid Email, ");

            }

            boolean pass_validate= Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&_*]).{8,}",passwordInput);
            if (pass_validate)
            {
                statement.setString(6, passwordInput);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid Password, rules of a password:\n 1- At least 8 chars\n 2- has at least one symbol\n 3- has at least one number\n 4- has lowercase letters or uppercase letters or mix of them ,  ");
            }

            statement.setInt(1, id);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null,"Data inserted successfully.");
            } else {
                JOptionPane.showMessageDialog(null,"Failed to insert data.");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}