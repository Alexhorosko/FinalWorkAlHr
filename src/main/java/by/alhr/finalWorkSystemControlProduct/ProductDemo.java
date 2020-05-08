package by.alhr.finalWorkSystemControlProduct;

import by.alhr.finalWorkSystemControlProduct.bean.Category;
import by.alhr.finalWorkSystemControlProduct.bean.Product;
import by.alhr.finalWorkSystemControlProduct.service.ProductService;

import java.math.BigDecimal;

public class ProductDemo {
    public static void main(String[] args) {
        Product product1 = new Product("Milk", BigDecimal.valueOf(2.25),"Milk from Minsk", Category.MILK_PRODUCTS);
        Product product2 = new Product("Cake", BigDecimal.valueOf(9.50),"Cake from Grodno", Category.CONFECTIONERY);
        Product product3 = new Product("Apple", BigDecimal.valueOf(3.15),"Apple from Parychi", Category.FRUIT);
        Product product4 = new Product("Orange", BigDecimal.valueOf(5.26),"Orange from Italy", Category.FRUIT);
        Product product5 = new Product("Cottage cheese", BigDecimal.valueOf(4.78),"Cottage cheese from Gomel", Category.MILK_PRODUCTS);
        Product product6 = new Product("Sour cream", BigDecimal.valueOf(2.13),"Sour cream from Rogachev", Category.MILK_PRODUCTS);
        Product product7 = new Product("Cookies", BigDecimal.valueOf(4.18),"Cookies from Bobryisk", Category.CONFECTIONERY);
        Product product8 = new Product("Melon", BigDecimal.valueOf(8.48),"Melon from Bulgaria", Category.FRUIT);
        Product product9 = new Product("Banana", BigDecimal.valueOf(3.05),"Banana from Nigeria", Category.FRUIT);

        ProductService productService = new ProductService();
        productService.addProduct(product1);
        productService.addProduct(product2);
        productService.addProduct(product3);
        productService.addProduct(product4);
        productService.addProduct(product5);
        productService.addProduct(product6);
        productService.addProduct(product7);
        productService.addProduct(product8);
        productService.addProduct(product9);

        productService.deleteProductById(6);
        productService.actualPriceWithDiscount("Orange", BigDecimal.valueOf(25));
        productService.actualPriceWithDiscount("Banana", BigDecimal.valueOf(15));
        productService.getProductById(9);
        productService.getListAllProduct();
        productService.getListByCategory(Category.MILK_PRODUCTS);
    }
}
