package org.example.database;

import org.example.Main;import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class ProductMain {

    //I want to be able to search for a product and then change the quantity in stock to reflect current inventory levels
    //I want this program to be tolerant of user error
    //1) I need to be able to prompt the user for which product to search for
    //2) I need to be able to show the products and allow the user to select a product to modify
    //2.5) use the id of the product the user just entered to do a query on the database
    //3) I need to prompt the user to enter the new quantity in stock
    //4)I need to set the new quantity in stock on the product and save it to the database

    private ProductDAO productDAO = new ProductDAO();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        //prompt the user to enter a product name
        String productName = inputProductSearch();

        //use our productDAO to run the query
        List<Product> products = productDAO.findLikeName(productName);

        //print our product new
        printProducts(products);

        //now validate that the user enters a proper product id
        Product selectedProduct = null;
        while( selectedProduct == null) {
            // #2 print the list of products

            int productId = promptForProductId();

            //#2.5 - what happens if the user enters a bad id number that does not exist
            //we have two types of problems that can happen here
            //first - the user enters a non numeric value
            //second - the user enters a numeric id that does not exist on the database
            selectedProduct = productDAO.findById(productId);
            if (selectedProduct == null) {
                System.out.println("You have entered an invalid product id");

            } else {
                break;
            }
        }

        //#3
        int quantity = promptQuantityInStock();
        System.out.println(quantity);

        //#4
        updateQuantityInStock(selectedProduct, quantity);

    }

    public void updateQuantityInStock(Product product, int quantity) {

        product.setQuantityInStock(quantity);
        productDAO.update(product);
    }

    public int promptQuantityInStock() {
        //really make an effort to try to understand what is happening here
        //because you will need to do this type of error checking on the SBA
        while (true) {
            try {
                System.out.println("Enter the new value for quantity in stock: ");
                int quantity = scanner.nextInt();
                return quantity;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number: ");
                scanner.nextLine();
            }
        }
    }

    public void printProducts(List<Product> products) {
        //print the results of the query
        System.out.println("ID | Product Name | Quantity In Stock");
        System.out.println("==============================================");
        for (Product product : products) {
            System.out.println(product.getId() + " | " + product.getProductName() + " | " + product.getQuantityInStock());
        }
        System.out.println("\n");

    }
        public int promptForProductId() {
        while(true) {
        try {
            System.out.println("\nEnter the product id to modify: ");
            int id = scanner.nextInt();
            return id;
        } catch (Exception e) {
            System.out.println("Please enter a valid number: ");
            scanner.nextLine();
        }
    }
}

    public String inputProductSearch() {
        System.out.print("Enter a product name to search for: ");
        String productName = scanner.nextLine();
        return productName;

    }

    public static void main(String[] args) {

        Main.ProductMain pm = new Main.ProductMain();
        pm.run();
    }
}
