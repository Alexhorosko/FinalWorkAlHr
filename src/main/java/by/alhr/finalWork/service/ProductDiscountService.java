package by.alhr.finalWork.service;

import by.alhr.finalWork.bean.Product;
import by.alhr.finalWork.interfaces.RepositoryDiscountInterfaces;
import by.alhr.finalWork.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ProductDiscountService extends ProductRepository implements RepositoryDiscountInterfaces {

    @Override
    public BigDecimal actualPriceWithDiscount(String nameProductDiscount, BigDecimal discount) {
        BigDecimal actualPrice = BigDecimal.valueOf(0);
        for (Product productName : productMap.values()) {
            if (productName.getNameProduct().equals(nameProductDiscount)) {
                productName.setDiscountProduct(discount);
                actualPrice = discountCalculation(productName);
            } else if (productName.getDiscountProduct() == null) {
                productName.setDiscountProduct(BigDecimal.valueOf(0));
                productName.setActualPriseProduct(productName.getPriceProduct());
            }
        }
        return actualPrice;
    }

    public BigDecimal discountCalculation(Product product) {
        product.setActualPriseProduct(product.getPriceProduct().
                subtract(product.getPriceProduct().multiply(product.getDiscountProduct()).
                        divide(BigDecimal.valueOf(100))));
        return product.getActualPriseProduct();
    }

    @Override
    public List<Product> getProductWithDiscount() {
        System.out.println("\nСПИСОК ПРОДУКТОВ СО СКИДКОЙ:");
        List<Product> discountList = new LinkedList<>();
        for (Product productWithDiscount : productMap.values()) {
            if (productWithDiscount.getDiscountProduct().compareTo(BigDecimal.ZERO) > 0) {
                discountList.add(productWithDiscount);
                System.out.print(productWithDiscount);
            }
        }
        return discountList;
    }
}
