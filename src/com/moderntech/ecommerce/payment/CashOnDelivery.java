package com.moderntech.ecommerce.payment;

public record CashOnDelivery(String deliveryAddress) implements PaymentMethod {
    @Override
    public String getDetails() {
        return "Наложенный платеж по адресу: " + deliveryAddress;
    }
}