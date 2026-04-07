package com.moderntech.ecommerce.models;

import com.moderntech.ecommerce.enums.ProductCategory;
/**
 * Иммутабельная сущность (record), представляющая товар в каталоге магазина.
 * Содержит базовую информацию о товаре, включая категорию и остаток на складе.
 */
public record Product(String id, String name, ProductCategory category, double price, int stock) {
}