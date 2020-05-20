package by.alhr.finalWork.repository;

import by.alhr.finalWork.bean.Product;
import by.alhr.finalWork.exception.ProductValidationException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static by.alhr.finalWork.repository.ProductRepository.productMap;
import static org.junit.Assert.*;

public class ProductRepositoryTest {

    @Test
    public void testSaveFirstProductToMap() throws ProductValidationException {
        ProductRepository productRepository = new ProductRepository();
        Map<Long, Product> productMapTest = new HashMap<>();

        productMapTest = productRepository.productMap;
        productRepository.saveFirstProductToMap();

        Map<Long, Product> expected = productMapTest;
        Map<Long, Product> actual = productMap;
        assertEquals(expected, actual);
    }
}