//import java.sql.*;
//import java.util.Scanner;
//public class logIn {
//    private Connection connection;
//    public logIn(Connection connection) {
//        this.connection = connection;
//    }
//    public int loginCustomer(Scanner scanner) {
//        System.out.println("Enter your email:");
//        String email = scanner.nextLine();
//
//        System.out.println("Enter your password:");
//        String password = scanner.nextLine();
//        try {
//            String sql = "SELECT CustomerID FROM Customer WHERE Email = ? AND password = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, email);
//            statement.setString(2, password);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                System.out.println("Login successful.");
//                int id=resultSet.getInt("CustomerID");
//                statement.close();
//                resultSet.close();
//                return id;
//            } else {
//                System.out.println("Invalid email or password. Please try again.");
//                statement.close();
//                resultSet.close();
//                return -1;
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//    public int loginAdmin(Scanner scanner) {
//        System.out.println("Enter your email:");
//        String email = scanner.nextLine();
//
//        System.out.println("Enter your password:");
//        String password = scanner.nextLine();
//        try {
//            String sql = "SELECT adminID FROM Admin WHERE Email = ? AND password = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, email);
//            statement.setString(2, password);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                System.out.println("Login successful.");
//                int id=resultSet.getInt("CustomerID");
//                statement.close();
//                resultSet.close();
//                return id;
//            } else {
//                System.out.println("Invalid email or password. Please try again.");
//                statement.close();
//                resultSet.close();
//                return -1;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//
//
//}




import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
public class logIn {
    private Connection connection;
    public logIn(Connection connection) {
        this.connection = connection;
    }
    public int loginCustomer(int ID,String password) {
        try {
            String sql = "SELECT CustomerID FROM Customer WHERE CustomerID = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ID);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null,"Login successful.");
                int id=resultSet.getInt("CustomerID");
                statement.close();
                resultSet.close();
                return id;
            } else {
                JOptionPane.showMessageDialog(null,"Invalid email or password. Please try again.");
                statement.close();
                resultSet.close();
                return -1;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int loginAdmin(int ID,String password) {
        try {
            String sql = "SELECT AdminID FROM Admin WHERE AdminID = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ID);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null,"Login successful.");
                int id = resultSet.getInt("AdminID");
                statement.close();
                resultSet.close();
                return id;
            } else {
                JOptionPane.showMessageDialog(null,"Invalid email or password. Please try again.");
                statement.close();
                resultSet.close();
                return -1;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


}