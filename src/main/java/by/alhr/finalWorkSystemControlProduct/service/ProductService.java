package by.alhr.finalWorkSystemControlProduct.service;

import by.alhr.finalWorkSystemControlProduct.bean.Category;
import by.alhr.finalWorkSystemControlProduct.bean.Product;
import by.alhr.finalWorkSystemControlProduct.interfaces.RepositoryInterfaces;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//    !!!!!!!!!!ДОПИСАТЬ:
//    В случае если основное поле не было введено - не записывать продукт,
//    а сообщить пользователю о том, что поле не введено или введено некорректно.

public class ProductService implements RepositoryInterfaces {
    public Map<Long, Product> productMap = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getIdProduct(), product);
    }

    @Override
    public Product getProductById(long idProduct) {
        System.out.println("Получение продукта по Id:");
        System.out.print(productMap.get(idProduct));
        return productMap.get(idProduct);
    }

    @Override
    public void deleteProductById(long idProduct) {
        productMap.remove(idProduct);
    }

    @Override
    public List<Product> getListByCategory(Category category) {
        System.out.println("\nСписок продуктов КАТЕГОРИИ:");
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
                productName.setActualPriseProduct(productName.getPriceProduct().
                        subtract(productName.getPriceProduct().multiply(productName.getDiscountProduct()).
                                divide(BigDecimal.valueOf(100))));
                actualPrice = productName.getActualPriseProduct();
            }
        }
        return actualPrice;
    }
}
