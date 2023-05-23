//import java.sql.*;
//import java.util.Scanner;
//
//public class menu {
//    private Scanner scanner;
//    private Connection connection;
//    private logIn login ;
//    private SignUp signUp;
//
//    int CustomerID ;
//    int AdminID ;
//
//    public menu(Connection connection) {
//        this.connection = connection;
//        scanner = new Scanner(System.in);
//        login = new logIn(connection);
//        signUp = new SignUp(connection);
//        CustomerID = -1;
//        AdminID = -1;
//    }
//
//    public boolean displayMenu() {
//        try {
//            while ( (AdminID == -1)  && (CustomerID == -1)) {
//                System.out.println("Welcome to the Booking Train System!");
//                System.out.println("Please choose an option:");
//                System.out.println("1. Sign Up");
//                System.out.println("2. Login");
//                System.out.println("3. Exit");
//                int choice = scanner.nextInt();
//                scanner.nextLine();
//
//                switch (choice) {
//                    case 1:
//                        System.out.println("Please choose user type:");
//                        System.out.println("1. Sign up as a customer");
//                        System.out.println("2. Sign up as an admin");
//                        int userTypeChoice = scanner.nextInt();
//                        scanner.nextLine();
//
//                        if (userTypeChoice == 1) {
//                            signUp.insertCustomer(scanner);
//                        } else if (userTypeChoice == 2) {
//                            signUp.insertAdmin(scanner);
//                        } else {
//                            System.out.println("Invalid choice. Please try again.");
//                        }
//                        break;
//                    case 2:
//                        System.out.println("Please choose login type:");
//                        System.out.println("1. Login as a user");
//                        System.out.println("2. Login as an admin");
//                        int loginTypeChoice = scanner.nextInt();
//                        scanner.nextLine();
//
//                        if (loginTypeChoice == 1) {
//                            CustomerID = login.loginCustomer(scanner);
//                        } else if (loginTypeChoice == 2) {
//                            AdminID = login.loginAdmin(scanner);
//                        } else {
//                            System.out.println("Invalid choice. Please try again.");
//                        }
//                        break;
//                    case 3:
//                        System.out.println("Thank you for using the Booking Train System. Goodbye!");
//                        signUp.closeConnection();
//                        return false;
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                        break;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            while(CustomerID != -1){
//                System.out.println("Welcome to the Booking Train System!");
//                System.out.println("Please choose an option:");
//                System.out.println("1. view available trips");
//                System.out.println("2. book a trip");
//                System.out.println("3. cancel the trip");
//                System.out.println("4. log out");
//                int choice = scanner.nextInt();
//                scanner.nextLine();
//                customer c = new customer(connection) ;
//                switch (choice) {
//                    case 1:
//                        c.viewTrips(CustomerID) ;
//                        break;
//                    case 2:
//                        c.Booking(CustomerID , scanner) ;
//                        break;
//                    case 3:
//                        c.cancel(CustomerID, scanner) ;
//                        break;
//                    case 4:
//                        CustomerID = -1 ;
//                        break;
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                        break;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//}