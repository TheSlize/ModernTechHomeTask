package com.moderntech.ecommerce.models;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс, представляющий корзину покупателя.
 * Позволяет управлять списком выбранных товаров и рассчитывать итоговую стоимость.
 */
public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();
    /**
     * Ставка НДС, используемая в магазине.
     */
    private static final double VAT_RATE = 0.22; // нынешний НДС уже 22%..

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(Product product) {
        items.removeIf(item -> item.product().id().equals(product.id()));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.product().price() * item.quantity())
                .sum();
    }

    /**
     * Вычисляет итоговую стоимость всех товаров в корзине с учетом НДС.
     *
     * @return сумма к оплате с учетом налога
     */
    public double getTotalWithVat() {
        return getTotalPrice() * (1 + VAT_RATE);
    }

    public void clear() {
        items.clear();
    }
}