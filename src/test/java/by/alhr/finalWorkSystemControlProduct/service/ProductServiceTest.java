package by.alhr.finalWorkSystemControlProduct.service;

import by.alhr.finalWorkSystemControlProduct.bean.Category;
import by.alhr.finalWorkSystemControlProduct.bean.Product;
import by.alhr.finalWorkSystemControlProduct.bean.ProductValidationException;
import org.junit.*;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;

public class ProductServiceTest {
    private final ProductService productService = new ProductService();
    private final Map<Long, Product> productMapTest = new HashMap<>();

    private final Product productTest1 = new Product("111", BigDecimal.valueOf(1.11), "11111", Category.FRUIT);
    private final Product productTest2 = new Product("222", BigDecimal.valueOf(2.22), "22222", Category.MILK_PRODUCTS);
    private final Product productTest3 = new Product("333", BigDecimal.valueOf(3.33), "33333", Category.FRUIT);

    public ProductServiceTest() throws ProductValidationException {
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
    public void testAddProduct() {
        Map<Long, Product> expected = productMapTest;
        Map<Long, Product> actual = productService.productMap;
        assertEquals(expected, actual);
    }

    @Test
    public void getProductById() throws ProductValidationException {
        Product expected = productTest2;
        Product actual = productService.getProductById(2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetListAllProduct() {
        productService.getListAllProduct();
        Map<Long, Product> expected = productMapTest;
        Map<Long, Product> actual = productService.productMap;
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteProductById() {
        productMapTest.remove(1L);
        productMapTest.remove(3L);

        productService.deleteProductById(1);
        productService.deleteProductById(3);

        Map<Long, Product> expected = productMapTest;
        Map<Long, Product> actual = productService.productMap;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetListByCategory() {
        List<Product> categoryListTest = new LinkedList<>();

        categoryListTest.add(productTest1);
        categoryListTest.add(productTest3);

        List<Product> expected = categoryListTest;
        List<Product> actual = productService.getListByCategory(Category.FRUIT);
        assertEquals(expected, actual);
    }

    @Test
    public void testActualPriceWithDiscount() {
        BigDecimal expected = BigDecimal.valueOf(2.997);
        BigDecimal actual = productService.actualPriceWithDiscount("333", BigDecimal.valueOf(10));
        assertEquals(expected, actual);
    }
}