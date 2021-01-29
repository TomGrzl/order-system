package de.neuefische.order;

import de.neuefische.product.Product;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderDBTest {

    @Test
    public void addAndGetOrderTest() {
        // GIVEN
        Collection<Product> products = new ArrayList<>();
        OrderDB orderDB = new OrderDB();
        Order order = new Order(products);
        Optional<Order> expected = Optional.of(order);

        // WHEN
        orderDB.addOrder(order);
        Optional<Order> actual = orderDB.getOrder(order.getId());

        // THEN
        assertEquals(expected, actual);

    }

    @Test
    public void getOrderListTest() {
        // GIVEN
        Collection<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Cheese"),
                new Product("Sausage")));

                Order order = new Order(products);
                Order anotherOrder = new Order(new ArrayList<>());

        OrderDB orderDB = new OrderDB();
        orderDB.addOrder(order);
        orderDB.addOrder(anotherOrder);

        // WHEN
        List<Order> actual = orderDB.getOrderList();

        // THEN
        List<Order> expected = new ArrayList<>();
        expected.add(order);
        expected.add(anotherOrder);

        assertEquals(expected, actual);
    }

}