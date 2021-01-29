package de.neuefische.product;

public class Product {

    private final String name;
    private final int id;
    private static int nextId = 1;

    public Product(String name) {
        this.name = name;
        this.id = nextId;
        nextId++;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " " +  name ;
    }

    public int getId() {
        return id;
    }
}
