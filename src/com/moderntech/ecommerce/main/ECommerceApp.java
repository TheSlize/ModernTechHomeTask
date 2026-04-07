package com.moderntech.ecommerce.main;

import com.moderntech.ecommerce.enums.OrderStatus;
import com.moderntech.ecommerce.enums.ProductCategory;
import com.moderntech.ecommerce.models.*;
import com.moderntech.ecommerce.payment.*;

import java.util.HashMap;
import java.util.Map;
/**
 * Главный класс приложения (Точка входа).
 * Демонстрирует базовые сценарии работы консольного интернет-магазина:
 * работу с каталогом, корзиной, оформление заказа и использование различных
 * стратегий оплаты (Ozon, Wildberries) и методов (карта, кошелек, наличные).
 */

/**
 * Главный класс приложения (Точка входа).
 * Демонстрирует базовые сценарии работы консольного интернет-магазина:
 * работу с каталогом, корзиной, оформление заказа и использование различных
 * стратегий оплаты (Ozon, Wildberries) и методов (карта, кошелек, наличные).
 */
public class ECommerceApp {
    public static void main(String [] args) {
        Map<String, Product> catalog = getStringProductMap();

        System.out.println("--- КАТАЛОГ ТОВАРОВ ---");
        for (Product p : catalog.values()) {
            System.out.printf("[%s] %s (%s) - %.2f руб. (В наличии: %d)\n",
                    p.id(), p.name(), p.category(), p.price(), p.stock());
        }

        Customer customer = new Customer("C100", "Иван Иванов", "ivan@example.com");
        System.out.println("\nПокупатель создан: " + customer.getName());

        ShoppingCart cart = new ShoppingCart();
        // допустим, для примера буду iPhone и две пары airPods-ов
        cart.addItem(catalog.get("P1"), 1);
        cart.addItem(catalog.get("P3"), 2);

        System.out.println("\n--- КОРЗИНА ---");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.product().name() + " x" + item.quantity());
        }
        System.out.printf("Итого без НДС: %.2f руб.\n", cart.getTotalPrice());
        System.out.printf("Итого с НДС (20%%): %.2f руб.\n", cart.getTotalWithVat());

        Order order = new Order(customer, cart);
        cart.clear();
        order.printOrderDetails();

        System.out.println("\nОбновление статуса заказа...");
        order.setStatus(OrderStatus.CONFIRMED);
        System.out.println("Новый статус: " + order.getStatus());


        Payment ozonPay = new OzonPayment();
        PaymentMethod card = new CreditCardPayment("1234567890123456", "IVAN IVANOV");
        ozonPay.processPayment(order, card, order.getTotalAmount());

        Payment wbPay = new WildberriesPayment();
        PaymentMethod wallet = new DigitalWalletPayment("YMoney-99887766");
        wbPay.processPayment(order, wallet, order.getTotalAmount());

        PaymentMethod cod = new CashOnDelivery("г. Москва, ул. Пушкина, д. 10");
        ozonPay.processPayment(order, cod, order.getTotalAmount());

        order.setStatus(OrderStatus.PROCESSING);

        System.out.println("\n--- ИТОГОВАЯ СВОДКА ---");
        System.out.println("Заказ: " + order.getId());
        System.out.println("Текущий статус: " + order.getStatus());
        System.out.println("Оплачено: " + order.getTotalAmount() + " руб.");
        System.out.println("Ожидайте доставку!");
    }

    private static Map<String, Product> getStringProductMap() {
        Map<String, Product> catalog = new HashMap<>();
        catalog.put("P1", new Product("P1", "iPhone 15", ProductCategory.SMARTPHONE, 95000.0, 10));
        catalog.put("P2", new Product("P2", "MacBook Air M2", ProductCategory.LAPTOP, 120000.0, 5));
        catalog.put("P3", new Product("P3", "AirPods Pro", ProductCategory.ACCESSORY, 25000.0, 50));
        catalog.put("P4", new Product("P4", "iPad Pro", ProductCategory.TABLET, 85000.0, 8));
        catalog.put("P5", new Product("P5", "Sony A7 IV", ProductCategory.CAMERA, 210000.0, 2));
        return catalog;
    }
}