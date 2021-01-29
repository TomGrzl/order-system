package de.neuefische.product;
import java.util.*;

public class ProductDB {

    private HashMap<Integer, Product> productList = new HashMap<>();

    public ProductDB(Product[] products){
        for (Product product : products) {
            productList.put(product.getId() ,product);
        }
    }

    public List<Product> getProductList() {

        List<Product> result = new ArrayList<>(productList.values());
        return result;
    }

    public Optional<Product> getProduct(Integer productId) {
        if(productList.containsKey(productId)){
        return Optional.of(productList.get(productId));
        }
        return Optional.empty();
    }
}