package de.neuefische;

import de.neuefische.product.Food;
import de.neuefische.product.Product;
import de.neuefische.product.ProductDB;

import java.util.List;

public class AppMain {

    public static void main(String[] args) {
        // Create new Product Database
        ProductDB productDataBase = new ProductDB(new Product[]{
                new Food("Cheese"),
                new Food("Sausage")
        });
        // List all Products included in Product Database
        listProducts(productDataBase);
    }

    public static void listProducts(ProductDB productDataBase){
        List<Product> listProductDB = productDataBase.getProductList();
        for (Product product : listProductDB) {
            System.out.println(product);
        }
    }


}

