package by.alhr.finalWorkProduct.interfaces;

import by.alhr.finalWorkProduct.bean.Category;
import by.alhr.finalWorkProduct.bean.Product;

import java.util.List;

public interface RepositoryInterfaces {

    void addProduct(Product product);

    Product getProductById(long id);

    void deleteProductById(long id);

    void getListAllProduct();

    List<Product> getListByCategory(Category category);
}