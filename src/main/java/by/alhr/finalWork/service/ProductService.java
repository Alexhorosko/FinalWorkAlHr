package by.alhr.finalWork.service;

import by.alhr.finalWork.bean.Category;
import by.alhr.finalWork.bean.Product;
import by.alhr.finalWork.interfaces.RepositoryInterfaces;
import by.alhr.finalWork.repository.ProductRepository;

import java.util.LinkedList;
import java.util.List;

public class ProductService extends ProductRepository implements RepositoryInterfaces {

    @Override
    public Product getProductById(long idProduct) {
        System.out.println("ПОЛУЧЕНИЕ ПРОДУКТА ПО Id:");
        System.out.println(productMap.get(idProduct));
        return productMap.get(idProduct);
    }

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getIdProduct(), product);
    }

    @Override
    public void deleteProductById(long idProduct) {
        productMap.remove(idProduct);
    }

    @Override
    public void getListAllProduct() {
        System.out.println("СПИСОК ВСЕХ ПРОДУКТОВ:");
        for (Product getAllListProduct : productMap.values()) {
            System.out.print(getAllListProduct);
        }
    }

    @Override
    public List<Product> getListByCategory(Category category) {
        System.out.println("\nСПИСОК ПРОДУКТА КАТЕГОРИИ:");
        List<Product> categoryList = new LinkedList<>();
        for (Product categoryProduct : productMap.values()) {
            if (categoryProduct.getCategoryProduct().equals(category)) {
                categoryList.add(categoryProduct);
                System.out.print(categoryProduct);
            }
        }
        return categoryList;
    }
}
