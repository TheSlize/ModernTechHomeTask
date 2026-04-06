package com.moderntech.ecommerce.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();
    private static final double VAT_RATE = 0.22; // нынешний НДС уже 22%..

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(Product product) {
        items.removeIf(item -> item.product().id().equals(product.id()));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.product().price() * item.quantity())
                .sum();
    }

    public double getTotalWithVat() {
        return getTotalPrice() * (1 + VAT_RATE);
    }

    public void clear() {
        items.clear();
    }
}