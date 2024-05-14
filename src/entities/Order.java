package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import orderStatus.OrderStatus;

public class Order {
	private LocalDate moment;
	private OrderStatus status;

	private List<OrderItem> items = new ArrayList<>();
	private Client client;

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
	//FAZER FUNCIONAR
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + moment);
		sb.append("\n Order Status:" + status);
		return sb.toString();
	}

}
