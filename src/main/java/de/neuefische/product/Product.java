package de.neuefische.product;

public class Product {

    private String name;
    private final int id;
    private static int nextId = 0;

    public Product(String name) {
        this.name = name;
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
