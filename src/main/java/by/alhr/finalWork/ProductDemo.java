package by.alhr.finalWork;

import by.alhr.finalWork.bean.Category;
import by.alhr.finalWork.bean.Product;
import by.alhr.finalWork.exception.ProductValidationException;
import by.alhr.finalWork.service.ProductDiscountService;
import by.alhr.finalWork.service.ProductService;

import java.math.BigDecimal;

public class ProductDemo {
    public static void main(String[] args) throws ProductValidationException {
        ProductDiscountService productDiscountService = new ProductDiscountService();
        ProductService productService = new ProductService();

        productService.saveFirstProductToMap();

        productService.addProduct(new Product("Kivi", BigDecimal.valueOf(4.15), "Kivi from Bulgaria", Category.FRUIT));
        productDiscountService.actualPriceWithDiscount("", BigDecimal.valueOf(0));
        productDiscountService.actualPriceWithDiscount("Milk", BigDecimal.valueOf(25));
        productDiscountService.actualPriceWithDiscount("Cottage cheese", BigDecimal.valueOf(10));
        productDiscountService.actualPriceWithDiscount("Kivi", BigDecimal.valueOf(30));

        productService.deleteProductById(4);

        productService.getProductById(9);

        productService.getListAllProduct();
        productService.getListByCategory(Category.FRUIT);
        productDiscountService.getProductWithDiscount();
    }
}
