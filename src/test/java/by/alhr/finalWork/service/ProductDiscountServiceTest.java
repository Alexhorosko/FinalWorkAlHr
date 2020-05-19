package by.alhr.finalWork.service;

import by.alhr.finalWork.bean.Category;
import by.alhr.finalWork.bean.Product;
import by.alhr.finalWork.exception.ProductValidationException;
import org.junit.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ProductDiscountServiceTest {
    private final ProductService productService = new ProductService();
    private final ProductDiscountService productDiscountService = new ProductDiscountService();
    private final Map<Long, Product> productMapTest = new HashMap<>();

    private final Product productTest1 = new Product("111", BigDecimal.valueOf(1.11), "11111", Category.FRUIT);
    private final Product productTest2 = new Product("222", BigDecimal.valueOf(2.22), "22222", Category.MILK_PRODUCTS);
    private final Product productTest3 = new Product("333", BigDecimal.valueOf(3.33), "33333", Category.FRUIT);

    public ProductDiscountServiceTest() throws ProductValidationException {
    }

    @Before
    public void setUpProductMapTest() {
        productMapTest.put(productTest1.getIdProduct(), productTest1);
        productMapTest.put(productTest2.getIdProduct(), productTest2);
        productMapTest.put(productTest3.getIdProduct(), productTest3);

        productService.addProduct(productTest1);
        productService.addProduct(productTest2);
        productService.addProduct(productTest3);
    }

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");
    }

    @After
    public void tearDownProductMapTest() {
        productService.productMap.clear();
        productMapTest.clear();
    }

    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All tests finished");
    }

    @Test
    public void testActualPriceWithDiscount() {
        BigDecimal expected = BigDecimal.valueOf(2.997);
        BigDecimal actual = productDiscountService.actualPriceWithDiscount("333", BigDecimal.valueOf(10));
        assertEquals(expected, actual);
    }

    @Test
    public void testGetProductWithDiscount() {
        List<Product> productpDiscountListTest = new LinkedList<>();

        productpDiscountListTest.add(productTest3);
        productDiscountService.actualPriceWithDiscount("333", BigDecimal.valueOf(10));
        List<Product> expected = productpDiscountListTest;
        List<Product> actual = productDiscountService.getProductWithDiscount();
        assertEquals(expected, actual);
    }
}