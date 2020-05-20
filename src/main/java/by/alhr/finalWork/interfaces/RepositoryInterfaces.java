package by.alhr.finalWork.interfaces;

import by.alhr.finalWork.bean.Category;
import by.alhr.finalWork.bean.Product;

import java.util.List;

public interface RepositoryInterfaces {

    void addProduct(Product product);

    Product getProductById(long id);

    void deleteProductById(long id);

    void getListAllProduct();

    List<Product> getListByCategory(Category category);
}