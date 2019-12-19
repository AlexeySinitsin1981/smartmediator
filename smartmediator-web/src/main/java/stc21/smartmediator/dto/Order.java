package stc21.smartmediator.dto;

import stc21.smartmediator.entity.ProductsEntity;

import java.math.BigDecimal;

public class Order {
    String name;
    BigDecimal price;
    Integer amount;
    BigDecimal maxAmount;

    public Order(String name, BigDecimal price, Integer amount, BigDecimal maxAmount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.maxAmount = maxAmount;
    }

    public Order(ProductsEntity productsEntity) {
        this.name = productsEntity.getName();
        this.price = productsEntity.getPrice();
        this.amount = 0;
        this.maxAmount = productsEntity.getQuantity();
    }

    public Order() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }
}
