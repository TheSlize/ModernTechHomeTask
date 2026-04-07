package com.moderntech.ecommerce.payment;

import com.moderntech.ecommerce.models.Order;
/**
 * Интерфейс, реализующий паттерн проектирования "Стратегия" (Strategy).
 * Определяет общий контракт для различных платежных шлюзов (провайдеров).
 */
public interface Payment {

    /**
     * Обрабатывает транзакцию оплаты заказа через конкретный шлюз.
     *
     * @param order  заказ, который необходимо оплатить
     * @param method выбранный способ оплаты (реквизиты)
     * @param amount сумма к списанию
     * @return статус обработки платежа
     */
    PaymentStatus processPayment(Order order, PaymentMethod method, double amount);
}