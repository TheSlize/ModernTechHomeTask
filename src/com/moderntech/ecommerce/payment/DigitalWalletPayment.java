package com.moderntech.ecommerce.payment;

public record DigitalWalletPayment(String walletId) implements PaymentMethod {
    @Override
    public String getDetails() {
        return "Электронный кошелек (" + walletId + ")";
    }
}