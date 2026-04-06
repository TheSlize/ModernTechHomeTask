package com.moderntech.ecommerce.payment;

import com.moderntech.ecommerce.models.Order;

public interface Payment {
    PaymentStatus processPayment(Order order, PaymentMethod method, double amount);
}