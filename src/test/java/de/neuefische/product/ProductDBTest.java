package de.neuefische.product;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ProductDBTest {


    @Test
    public void getProductListTest(){
        // GIVEN
        Product[] products = new Product[]{
                new Product("Kaese"),
                new Product("Wurst")
        };
        ProductDB productDB = new ProductDB(products);

        //WHEN
        Collection<Product> actual = productDB.getProductList();

        //THEN
        Collection<Product> expected = Arrays.asList(products);
        assertEquals(expected, actual);
    }






}