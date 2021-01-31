package de.neuefische.product;

import java.util.*;

public class ProductDB {

    private int nextProductID = 1;

    private HashMap<Integer, Product> productList = new HashMap<>();

    public ProductDB(Product[] products) {
        for (Product product : products) {
            addProduct(product);
        }
    }

    public void addProduct(Product product) throws IllegalArgumentException {
        if (productList.containsValue(product))
            throw new IllegalArgumentException("Product already in DB");

        product.setId(nextProductID);
        productList.put(nextProductID, product);
        nextProductID++;
    }

    public List<Product> getProductList() {

        List<Product> result = new ArrayList<>(productList.values());
        return result;
    }

    public Optional<Product> getProduct(Integer productId) {
        if (productList.containsKey(productId)) {
            return Optional.of(productList.get(productId));
        }
        return Optional.empty();
    }
}