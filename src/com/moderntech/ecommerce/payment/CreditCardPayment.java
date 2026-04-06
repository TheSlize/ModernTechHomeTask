package com.moderntech.ecommerce.payment;

public record CreditCardPayment(String cardNumber, String cardHolder) implements PaymentMethod {
    @Override
    public String getDetails() {
        return "Банковская карта (заканчивается на " + cardNumber.substring(Math.max(0, cardNumber.length() - 4)) + ")";
    }
}