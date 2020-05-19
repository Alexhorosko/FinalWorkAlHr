package by.alhr.finalWorkProduct.repository;

import by.alhr.finalWorkProduct.bean.Category;
import by.alhr.finalWorkProduct.bean.Product;
import by.alhr.finalWorkProduct.exception.ProductValidationException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    public static Map<Long, Product> productMap = new HashMap<>();

    public void saveFirstProductToMap() throws ProductValidationException {
        productMap.put(1L, new Product("Milk", BigDecimal.valueOf(2.12), "Milk from Minsk", Category.MILK_PRODUCTS));
        productMap.put(2L, new Product("Cake", BigDecimal.valueOf(9.50), "Cake from Grodno", Category.CONFECTIONERY));
        productMap.put(3L, new Product("Apple", BigDecimal.valueOf(3.24), "Apple from Parychi", Category.FRUIT));
        productMap.put(4L, new Product("Orange", BigDecimal.valueOf(5.26), "Orange from Italy", Category.FRUIT));
        productMap.put(5L, new Product("Cottage cheese", BigDecimal.valueOf(4.78), "Cottage cheese from Gomel", Category.MILK_PRODUCTS));
        productMap.put(6L, new Product("Sour cream", BigDecimal.valueOf(2.13), "Sour cream from Rogachev", Category.MILK_PRODUCTS));
        productMap.put(7L, new Product("Cookies", BigDecimal.valueOf(4.18), "Cookies from Bobryisk", Category.CONFECTIONERY));
        productMap.put(8L, new Product("Melon", BigDecimal.valueOf(8.48), "Melon from Bulgaria", Category.FRUIT));
        productMap.put(9L, new Product("Banana", BigDecimal.valueOf(3.33), "Banana from Nigeria", Category.FRUIT));
    }
}
