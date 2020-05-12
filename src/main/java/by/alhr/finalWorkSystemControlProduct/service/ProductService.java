package by.alhr.finalWorkSystemControlProduct.service;

import by.alhr.finalWorkSystemControlProduct.bean.Category;
import by.alhr.finalWorkSystemControlProduct.bean.Product;
import by.alhr.finalWorkSystemControlProduct.interfaces.RepositoryInterfaces;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductService implements RepositoryInterfaces {
    public Map<Long, Product> productMap = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getIdProduct(), product);
    }

    @Override
    public Product getProductById(long idProduct) {
        System.out.println("ПОЛУЧЕНИЕ ПРОДУКТА ПО Id:");
        System.out.println(productMap.get(idProduct));
        return productMap.get(idProduct);
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

    @Override
    public BigDecimal actualPriceWithDiscount(String nameProductDiscount, BigDecimal discount) {
        BigDecimal actualPrice = null;
        for (Product productName : productMap.values()) {
            if (productName.getNameProduct().equals(nameProductDiscount)) {
                productName.setDiscountProduct(discount);
                actualPrice = discountCalculation(productName);
            }
        }
        return actualPrice;
    }

    public BigDecimal discountCalculation(Product product) {
        return product.setActualPriseProduct(product.getPriceProduct().
                subtract(product.getPriceProduct().multiply(product.getDiscountProduct()).
                        divide(BigDecimal.valueOf(100))));
    }
}
