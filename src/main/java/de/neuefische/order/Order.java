package de.neuefische.order;

import de.neuefische.product.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Order {
    private final Collection<Product> products;
    private final int id;
    private static int nextId = 1;

    public Order() {
        this.products = new ArrayList<>();
        this.id = nextId;
        nextId++;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public int getId() {
        return id;
    }

    public void add(Product productToAdd) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        String orderString = "Order " + id + ": ";
        for (Product product : products) {
            orderString += product + " ";
        }

        return orderString;
    }
}
