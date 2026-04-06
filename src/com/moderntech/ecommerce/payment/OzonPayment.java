package com.moderntech.ecommerce.payment;

import com.moderntech.ecommerce.models.Order;

public class OzonPayment implements Payment {
    @Override
    public PaymentStatus processPayment(Order order, PaymentMethod method, double amount) {
        System.out.println("\n[OZON PAY] Инициализация платежа...");
        System.out.println("[OZON PAY] Заказ #" + order.getId() + " на сумму: " + amount + " руб.");
        System.out.println("[OZON PAY] Способ оплаты: " + method.getDetails());
        System.out.println("[OZON PAY] Платеж успешно проведен через шлюз Ozon.");
        return PaymentStatus.SUCCESS;
    }
}