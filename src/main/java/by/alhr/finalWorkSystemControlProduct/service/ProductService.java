package by.alhr.finalWorkSystemControlProduct.service;

import by.alhr.finalWorkSystemControlProduct.bean.Category;
import by.alhr.finalWorkSystemControlProduct.bean.Product;
import by.alhr.finalWorkSystemControlProduct.bean.ProductValidationException;
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
    public Product getProductById(long idProduct) throws ProductValidationException {
        System.out.println("ПОЛУЧЕНИЕ ПРОДУКТА ПО Id:");
//        try {
            System.out.println(productMap.get(idProduct));
//        } catch () {
//       System.out.println("Ошибка! Файл не найден!");
//        if (productMap.get(idProduct) == ')'){
//            throw new ProductValidationException("поле не введено или введено некорректно!!!");
//        }
        return productMap.get(idProduct);
    }
//    //        public Book findById(String id) throws ItemNotFoundException {
////        if (bookList.get(id) == null) {
////            throw new ItemNotFoundException("Не найдена");
////        }
////        System.out.println("id книги: " + bookList.get(id));
////        return null;
////    }

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
                productName.setActualPriseProduct(productName.getPriceProduct().
                        subtract(productName.getPriceProduct().multiply(productName.getDiscountProduct()).
                                divide(BigDecimal.valueOf(100))));
                actualPrice = productName.getActualPriseProduct();
            }
        }
        return actualPrice;
    }
}
