package by.alhr.finalWorkSystemControlProduct.interfaces;

import by.alhr.finalWorkSystemControlProduct.bean.Category;
import by.alhr.finalWorkSystemControlProduct.bean.Product;
import by.alhr.finalWorkSystemControlProduct.bean.ProductValidationException;

import java.math.BigDecimal;
import java.util.List;

public interface RepositoryInterfaces {

    void addProduct(Product product);

    Product getProductById(long id) throws ProductValidationException;

    void deleteProductById(long id);

    void getListAllProduct();

    List<Product> getListByCategory(Category category);

    BigDecimal actualPriceWithDiscount(String nameProductDiscount, BigDecimal discount);
}
