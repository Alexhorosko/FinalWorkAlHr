package by.alhr.finalWorkProduct.repository;

import by.alhr.finalWorkProduct.bean.Category;
import by.alhr.finalWorkProduct.bean.Product;
import by.alhr.finalWorkProduct.exception.ProductValidationException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static by.alhr.finalWorkProduct.repository.ProductRepository.productMap;
import static org.junit.Assert.*;

public class ProductRepositoryTest {

    @Test
    public void testSaveFirstProductToMap() throws ProductValidationException {
        ProductRepository productRepository = new ProductRepository();
        Map<Long, Product> productMapTest = new HashMap<>();

        Product productTest1 = new Product("Milk", BigDecimal.valueOf(2.12), "Milk from Minsk", Category.MILK_PRODUCTS);
        Product productTest2 = new Product("Cake", BigDecimal.valueOf(9.50), "Cake from Grodno", Category.CONFECTIONERY);
        Product productTest3 = new Product("Apple", BigDecimal.valueOf(3.24), "Apple from Parychi", Category.FRUIT);
        Product productTest4 = new Product("Orange", BigDecimal.valueOf(5.26), "Orange from Italy", Category.FRUIT);
        Product productTest5 = new Product("Cottage cheese", BigDecimal.valueOf(4.78), "Cottage cheese from Gomel", Category.MILK_PRODUCTS);
        Product productTest6 = new Product("Sour cream", BigDecimal.valueOf(2.13), "Sour cream from Rogachev", Category.MILK_PRODUCTS);
        Product productTest7 = new Product("Cookies", BigDecimal.valueOf(4.18), "Cookies from Bobryisk", Category.CONFECTIONERY);
        Product productTest8 = new Product("Melon", BigDecimal.valueOf(8.48), "Melon from Bulgaria", Category.FRUIT);
        Product productTest9 = new Product("Banana", BigDecimal.valueOf(3.33), "Banana from Nigeria", Category.FRUIT);

        productMapTest.put(productTest1.getIdProduct(), productTest1);
        productMapTest.put(productTest2.getIdProduct(), productTest2);
        productMapTest.put(productTest3.getIdProduct(), productTest3);
        productMapTest.put(productTest4.getIdProduct(), productTest4);
        productMapTest.put(productTest5.getIdProduct(), productTest5);
        productMapTest.put(productTest6.getIdProduct(), productTest6);
        productMapTest.put(productTest7.getIdProduct(), productTest7);
        productMapTest.put(productTest8.getIdProduct(), productTest8);
        productMapTest.put(productTest9.getIdProduct(), productTest9);

        productRepository.saveFirstProductToMap();

        Map<Long, Product> expected = productMapTest;
        Map<Long, Product> actual = productMap;
        assertEquals(expected, actual);
    }
}