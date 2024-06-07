//package org.example;
//
//import org.example.database.dao.CustomerDAO;
//import org.example.database.dao.OrderDAO;
//import org.hibernate.query.Order;
//
//import java.util.InputMismatchException;
//import java.util.List;
//import java.util.Scanner;
//
//public class OrderMain {
//
//    private OrderDAO orderDAO= new OrderDAO();
//    private CustomerDAO customerDAO = new CustomerDAO();
//    Scanner scanner = new Scanner(System.in);
//
//    public void run() {
//
//
//        int customerId = enterCustomerId();
//
//
//        List<Order> orders = orderDAO.findById(customerId);
//
//        System.out.println(orders);
//
//    }
//
//
//    public int enterCustomerId() {
//
//        while (true) {
//            try {
//                System.out.println("Enter a Customer Id to search for: ");
//                int id = scanner.nextInt();
//                return id;
//            } catch (InputMismatchException e) {
//                System.out.println("Your entry is not a valid Customer Id: ");
//                scanner.nextLine();
//
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//        OrderMain om = new OrderMain();
//        om.run();
//    }
//
//
//}
