package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	@SuppressWarnings("unused")
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();

	Date currentDate = new Date();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.moment = currentDate;
		this.status = status;
		this.client = client;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItems(OrderItem item) {
		items.add(item);
	}
	
	public void removeItems(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double sum = 0;
		for (OrderItem i : items) {
			sum += i.subTotal();
		}
		return sum;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	public void orderSummary() {
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment: " + sdf.format(currentDate));
		System.out.println("Order Status: " + status);
		System.out.println("Client: " + client.getName() + " (" + sdf2.format(client.getBirthDate()) + ") - " + client.getEmail());
		System.out.println("Order Items: ");
		for (OrderItem i : items) {
			System.out.println(i.getProduct().getName() + ", " + i.getProduct().getPrice() + ", "
			+ "Quantity: " + i.getQuantity() + ", " + "Subtotal: " + i.subTotal());
		}
	}
	
}
