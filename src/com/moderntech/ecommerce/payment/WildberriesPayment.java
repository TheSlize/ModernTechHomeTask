package com.moderntech.ecommerce.payment;

import com.moderntech.ecommerce.models.Order;
/**
 * Конкретная реализация стратегии оплаты (Payment).
 * Инкапсулирует логику взаимодействия с платежным шлюзом.
 */
public class WildberriesPayment implements Payment {
    @Override
    public PaymentStatus processPayment(Order order, PaymentMethod method, double amount) {
        System.out.println("\n[WB PAY] Подключение к серверам Wildberries...");
        System.out.println("[WB PAY] Оплата заказа #" + order.getId() + ". Сумма: " + amount + " руб.");
        System.out.println("[WB PAY] Метод: " + method.getDetails());
        System.out.println("[WB PAY] Транзакция одобрена Wildberries.");
        return PaymentStatus.SUCCESS;
    }
}