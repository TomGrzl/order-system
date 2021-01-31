package de.neuefische.order;

import de.neuefische.product.Food;
import de.neuefische.product.Product;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderDBTest {

    @Test
    public void addAndGetOrderTest() {
        // GIVEN
        OrderDB orderDB = new OrderDB();
        Order order = new Order();
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
        Product cheese = new Food("Cheese");
        Product sausage = new Food("Sausage");

        Order order = new Order();
        order.add(cheese);
        order.add(sausage);

        Order anotherOrder = new Order();

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