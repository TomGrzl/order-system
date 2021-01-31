package de.neuefische.product;

import java.util.Objects;

public class Food implements Product {

    private final String productName;
    private int id;

    public Food(String name) {
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
        Food food = (Food) o;
        return id == food.id && Objects.equals(productName, food.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, id);
    }

    @Override
    public String toString() {
        return id +  " " + productName ;
    }
}
