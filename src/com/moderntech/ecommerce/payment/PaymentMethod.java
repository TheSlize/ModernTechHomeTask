package com.moderntech.ecommerce.payment;
/**
 * Изолированный (sealed) интерфейс для представления реквизитов оплаты.
 * Строго ограничивает список допустимых способов оплаты (карта, кошелек, наличные),
 * предотвращая создание несанкционированных реализаций.
 */
public sealed interface PaymentMethod permits CreditCardPayment, DigitalWalletPayment, CashOnDelivery {
    String getDetails();
}