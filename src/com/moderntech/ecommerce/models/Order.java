package com.moderntech.ecommerce.models;

import com.moderntech.ecommerce.enums.OrderStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private final String id;
    private final Customer customer;
    private final List<OrderItem> items;
    private final double totalAmount;
    private OrderStatus status;

    public Order(Customer customer, ShoppingCart cart) {
        this.id = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.customer = customer;
        this.items = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            this.items.add(new OrderItem(item.product(), item.quantity(), item.product().price()));
        }

        this.totalAmount = cart.getTotalWithVat();
        this.status = OrderStatus.PENDING;
    }

    public String getId() { return id; }
    public double getTotalAmount() { return totalAmount; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public void printOrderDetails() {
        System.out.println("\n=== ДЕТАЛИ ЗАКАЗА ===");
        System.out.println("ID Заказа: " + id);
        System.out.println("Покупатель: " + customer.getName());
        System.out.println("Статус: " + status);
        System.out.println("Товары:");
        for (OrderItem item : items) {
            System.out.printf(" - %s x%d : %.2f руб.\n", item.product().name(), item.quantity(), item.priceAtPurchase() * item.quantity());
        }
        System.out.printf("ИТОГО (с НДС): %.2f руб.\n", totalAmount);
        System.out.println("=====================");
    }
}