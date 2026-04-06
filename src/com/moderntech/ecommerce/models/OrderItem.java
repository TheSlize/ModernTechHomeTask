package com.moderntech.ecommerce.models;

public record OrderItem(Product product, int quantity, double priceAtPurchase) {
}