package de.neuefische.product;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ProductDB {

    private HashMap<Integer, Product> productList = new HashMap<>();

    public ProductDB(Product[] products){
        for (Product product : products) {

            productList.put(product.getId() ,product);

        }

    }

    public List<Product> getProductList() {



        return Arrays.asList(productList.values().toArray());
    }

    public Product getProduct(Integer productId) {

        return null;
    }

}
