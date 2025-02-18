package ru.aston.dvorianchykov_sa.task3;

import java.math.BigDecimal;

public class Product {

    private String name;
    private String category;
    private BigDecimal price;

    public Product() {

    }

    public Product(String name, String category, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Product name: %s, category: %s, price: %s", name, category, price);
    }

    public void print() {
        System.out.println(this);
    }
}
