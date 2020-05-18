package by.alhr.finalWorkSystemControlProduct;

import by.alhr.finalWorkSystemControlProduct.bean.Category;
import by.alhr.finalWorkSystemControlProduct.bean.Product;
import by.alhr.finalWorkSystemControlProduct.exception.ProductValidationException;
import by.alhr.finalWorkSystemControlProduct.service.ProductService;

import java.math.BigDecimal;

public class ProductDemo {
    public static void main(String[] args) throws ProductValidationException {

        ProductService productService = new ProductService();
        productService.saveFirstProductToMap();

        productService.addProduct(new Product("Kivi", BigDecimal.valueOf(4.15), "Kivi from Bulgaria", Category.FRUIT));

        productService.deleteProductById(4);
        productService.actualPriceWithDiscount("Milk", BigDecimal.valueOf(25));
        productService.actualPriceWithDiscount("Banana", BigDecimal.valueOf(10));
        productService.actualPriceWithDiscount("Kivi", BigDecimal.valueOf(30));
        productService.getProductById(9);
        productService.getListAllProduct();
        productService.getListByCategory(Category.FRUIT);
    }
}
