package de.neuefische.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProductDBTest {

    @Test
    public void getProductListTest() {
        // GIVEN
        Product[] products = new Product[]{
                new Food("Cheese"),
                new Food("Sausage")
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
    public void getProductTest(ProductDB productDB, Integer id, Optional<Product> expected) {

        // WHEN
        Optional<Product> actual = productDB.getProduct(id);

        // THEN
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> getProductTest() {
        // GIVEN
        Product cheese = new Food("Cheese");
        Product sausage = new Food("Sausage");
        Product hat = new Clothing("Hat");

        Product[] products = new Product[]{
                cheese, sausage
        };
        ProductDB productDB = new ProductDB(products);

        return  Stream.of(
          Arguments.arguments(productDB,cheese.getId(), Optional.of(cheese)),
          Arguments.arguments(productDB,sausage.getId(),Optional.of(sausage)),
          Arguments.arguments(productDB, hat.getId(), Optional.empty())
        );
    }


}

