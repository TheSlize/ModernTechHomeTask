package com.moderntech.ecommerce.models;
/**
 * Запись, представляющая позицию в оформленном заказе.
 * В отличие от CartItem, фиксирует цену товара на момент покупки (priceAtPurchase),
 * чтобы изменение цены в каталоге не влияло на историю старых заказов.
 */
public record OrderItem(Product product, int quantity, double priceAtPurchase) {
}