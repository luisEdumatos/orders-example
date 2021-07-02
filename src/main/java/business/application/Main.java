package business.application;

import business.entities.Client;
import business.entities.Order;
import business.entities.OrderItem;
import business.entities.Product;
import business.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        //Information of Client
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY):");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(name,email,birthDate);

        //Information of order
        System.out.println();
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        Order order = new Order(new Date(), status, client);

        //Number of items
        System.out.print("How many items to this order? ");
        int numItems = sc.nextInt();

        for (int i=0; i<numItems; i++) {
            System.out.println("Enter #" + (i+1) + " item data: ");
            System.out.print("Product name: ");
            sc.nextLine();
            name = sc.nextLine();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            Product product = new Product(name, price);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            OrderItem orderItem = new OrderItem(quantity, product);

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMARY: ");
        System.out.println(order);

    }
}
