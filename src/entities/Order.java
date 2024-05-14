package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import orderStatus.OrderStatus;

public class Order {
	private LocalDate moment;
	private OrderStatus status;

	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Order(LocalDate moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDate getMoment() {
		return moment;
	}

	public void setMoment(LocalDate moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItems(OrderItem item) {
		this.items.add(item);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Double total() {
		double total = 0.0;
		for (OrderItem items : items) {
			total = total + items.subTotal();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + moment.format(fmt));
		sb.append("\nOrder Status:" + status);
		return sb.toString();
	}

}
