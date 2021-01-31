package de.neuefische.product;

import java.util.Objects;

public class Clothing implements Product {

    private final String productName;
    private int id;

    public Clothing(String name) {
        productName = name;
    }

    @Override
    public String getName() {
        return productName;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothing clothing = (Clothing) o;
        return id == clothing.id && Objects.equals(productName, clothing.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, id);
    }

    @Override
    public String toString() {
        return id + " " + productName;
    }
}
