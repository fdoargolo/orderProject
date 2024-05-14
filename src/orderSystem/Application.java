package orderSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import orderStatus.OrderStatus;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter client data;");
		System.out.print("Name: ");
		String clientName = scanner.nextLine();
		System.out.print("Email: ");
		String clientEmail = scanner.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		LocalDate clientBirth = LocalDate.parse(scanner.nextLine(), fmt);

		Client client = new Client(clientName, clientEmail, clientBirth);

		System.out.println("Enter the order data:");
		System.out.print("Status:  ");
		String orderStatus = scanner.next();
		LocalDate orderDate = LocalDate.now();

		Order order = new Order(orderDate, OrderStatus.valueOf(orderStatus), client);

		System.out.print("How many items to this order? ");
		int itemsQuantity = scanner.nextInt();
		scanner.nextLine();
		
		OrderItem item = new OrderItem();

		for (int i = 0; i < itemsQuantity; i++) {
			System.out.println("Enter " + (i + 1) + " item data:");
			System.out.print("Product name: ");
			String productName = scanner.nextLine();
			System.out.print("Product price: ");
			double productPrice = scanner.nextDouble();
			System.out.print("Quntity: ");
			int productQuantity = scanner.nextInt();
			scanner.nextLine();

			Product product = new Product(productName, productPrice);
			item = new OrderItem(productQuantity, productPrice, product);
			order.addItems(item);

		}
		scanner.close();

		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		System.out.println(client);
		System.out.println("Order items");
		for (OrderItem items : order.getItems()) {
			System.out.println(items);
		}
		System.out.println("\n Total price:" + order.total()); //Create the function TOTAL (Order.java)

	}

}
