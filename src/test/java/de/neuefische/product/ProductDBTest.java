package de.neuefische.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProductDBTest {

    @Test
    public void getProductListTest() {
        // GIVEN
        Product[] products = new Product[]{
                new Product("Cheese"),
                new Product("Sausage")
        };
        ProductDB productDB = new ProductDB(products);

        // WHEN
        Collection<Product> actual = productDB.getProductList();

        // THEN
        Collection<Product> expected = Arrays.asList(products);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource
    public void getProductTest(ProductDB productDB, Integer id, Product expected) {

        // WHEN
        Product actual = productDB.getProduct(id);

        // THEN
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> getProductTest() {
        // GIVEN
        Product cheese = new Product("Cheese");
        Product sausage = new Product("Sausage");
        Product bread = new Product("Bread");

        Product[] products = new Product[]{
                cheese, sausage
        };
        ProductDB productDB = new ProductDB(products);

        return  Stream.of(
          Arguments.arguments(productDB,cheese.getId(), cheese),
          Arguments.arguments(productDB,sausage.getId(),sausage),
          Arguments.arguments(productDB, bread.getId(), null)
        );
    }
}