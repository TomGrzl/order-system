package de.neuefische.order;

import de.neuefische.product.Product;

import java.util.Collection;

public class Order {
    private Collection<Product> products;
    private final int id;
    private static int nextId = 0;

    public Order(Collection<Product> products) {
        this.products = products;
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
}
