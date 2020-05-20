package by.alhr.finalWork.interfaces;

import by.alhr.finalWork.bean.Product;

import java.math.BigDecimal;
import java.util.List;

public interface RepositoryDiscountInterfaces {

    BigDecimal actualPriceWithDiscount(String nameProductDiscount, BigDecimal discount);

    List<Product> getProductWithDiscount();
}
