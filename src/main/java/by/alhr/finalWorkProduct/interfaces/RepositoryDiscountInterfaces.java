package by.alhr.finalWorkProduct.interfaces;

import by.alhr.finalWorkProduct.bean.Product;

import java.math.BigDecimal;
import java.util.List;

public interface RepositoryDiscountInterfaces {

    BigDecimal actualPriceWithDiscount(String nameProductDiscount, BigDecimal discount);

    List<Product> getProductWithDiscount();
}
