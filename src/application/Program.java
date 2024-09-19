package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date: ");
		Date date = sdf.parse(sc.next());
		System.out.print("Enter order status: ");
		sc.nextLine();
		String status = sc.nextLine();
		System.out.print("How many items to this order? ");
		Integer n = sc.nextInt();
		
		Order order = new Order(date, OrderStatus.valueOf(status), new Client(name, email, date));
		
		for (int i = 0; i < n; i++) {
			System.out.printf("Enter #%d item data:\n", i + 1);
			System.out.print("Product Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product Price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			OrderItem item = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
			order.addItems(item);
		}
		
		System.out.println();
		
		order.orderSummary();
		
		sc.close();

	}

}
