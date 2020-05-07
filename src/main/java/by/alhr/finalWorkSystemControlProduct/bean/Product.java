package by.alhr.finalWorkSystemControlProduct.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Product implements Serializable {
    private static AtomicLong GUID = new AtomicLong();
    private String nameProduct;
    private Long idProduct;
    private BigDecimal priceProduct;             //example: 0.14
    BigDecimal discountProduct;          //example: 0.05, т.е 5%
    String descriptionProduct;           //описание example: Tasty apples from Latvia
    BigDecimal actualPriseProduct;
    private Category categoryProduct;

    public Product() {
    }

    public Product(String nameProduct, BigDecimal priceProduct,
                   String descriptionProduct, Category categoryProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
        this.categoryProduct = categoryProduct;
        idProduct = GUID.incrementAndGet();
    }

    public static AtomicLong getGUID() {
        return GUID;
    }

    public static void setGUID(AtomicLong GUID) {
        Product.GUID = GUID;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public BigDecimal getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(BigDecimal priceProduct) {
        this.priceProduct = priceProduct;
    }

    public BigDecimal getDiscountProduct() {
        return discountProduct;
    }

    public void setDiscountProduct(BigDecimal discountProduct) {
        this.discountProduct = discountProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public BigDecimal getActualPriseProduct() {
        return actualPriseProduct;
    }

    public BigDecimal setActualPriseProduct(BigDecimal actualPriseProduct) {
        this.actualPriseProduct = actualPriseProduct;
        return actualPriseProduct;
    }

    public Category getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(Category categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct) &&
                Objects.equals(idProduct, product.idProduct) &&
                Objects.equals(priceProduct, product.priceProduct) &&
                Objects.equals(discountProduct, product.discountProduct) &&
                Objects.equals(descriptionProduct, product.descriptionProduct) &&
                Objects.equals(actualPriseProduct, product.actualPriseProduct) &&
                categoryProduct == product.categoryProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, idProduct, priceProduct, discountProduct, descriptionProduct, actualPriseProduct, categoryProduct);
    }

    @Override
    public String toString() {
        return  "\nProduct information: \n" +
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
