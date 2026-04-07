package com.moderntech.ecommerce.models;
/**
 * Запись, представляющая позицию в корзине.
 * Связывает конкретный товар (Product) и выбранное количество (quantity).
 */
public record CartItem(Product product, int quantity) {
}