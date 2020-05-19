package by.alhr.finalWorkProduct.bean;

import by.alhr.finalWorkProduct.exception.ProductValidationException;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@NoArgsConstructor

public class Product implements Serializable {
    private static AtomicLong GUID = new AtomicLong();
    private String nameProduct;
    private Long idProduct;
    private BigDecimal priceProduct;
    BigDecimal discountProduct;
    String descriptionProduct;
    BigDecimal actualPriseProduct;
    private Category categoryProduct;

    public Product(String nameProduct, BigDecimal priceProduct, String descriptionProduct,
                   Category categoryProduct) throws ProductValidationException {
        if (nameProduct.isEmpty()) {
            throw new ProductValidationException("поле не введено или введено некорректно!!!");
        } else if (priceProduct.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("поле не введено или введено некорректно!!!");
        } else if (descriptionProduct.isEmpty()) {
            throw new ProductValidationException("поле не введено или введено некорректно!!!");
        }
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
        this.categoryProduct = categoryProduct;
        idProduct = GUID.incrementAndGet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct) &&
                Objects.equals(priceProduct, product.priceProduct) &&
                Objects.equals(discountProduct, product.discountProduct) &&
                Objects.equals(descriptionProduct, product.descriptionProduct) &&
                Objects.equals(actualPriseProduct, product.actualPriseProduct) &&
                categoryProduct == product.categoryProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, priceProduct, discountProduct, descriptionProduct, actualPriseProduct, categoryProduct);
    }

    @Override
    public String toString() {
        return "\nProduct information: \n" +
                "Id: " + idProduct + ";" + "\n" +
                "Category: " + categoryProduct + ";" + "\n" +
                "Name: " + nameProduct + ";" + "\n" +
                "Description: " + descriptionProduct + ";" + "\n" +
                "Regular price: " + priceProduct + ";" + "\n" +
                "Discount: " + discountProduct + "%;" + "\n" +
                "Actual prise: " + actualPriseProduct + ";" +
                "\n";
    }
}
