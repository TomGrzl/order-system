package de.neuefische;

import de.neuefische.order.Order;
import de.neuefische.product.Clothing;
import de.neuefische.product.Food;
import de.neuefische.product.Product;
import de.neuefische.product.ProductDB;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class OrderServiceTest {

    @Test
    void addOrdersTest() {
        // GIVEN
        Product cheese = new Food("Cheese");
        Product meat = new Food("Meat");
        Product salad = new Food("Salad");

        ProductDB productDB = new ProductDB(new Product[]{cheese, meat, salad});
        OrderService orderService = new OrderService(productDB);

        // WHEN
        orderService.addProductToOrder(cheese.getId());
        orderService.addProductToOrder(meat.getId());
        orderService.addProductToOrder(cheese.getId());

        // THEN
        Order expectedOrder = new Order();
        expectedOrder.add(cheese);
        expectedOrder.add(meat);
        expectedOrder.add(cheese);

        Optional<Order> actual = orderService.getCurrentOrder();
        Optional<Order> expected = Optional.of(expectedOrder);

        assertEquals(expected, actual);
    }

    @Test
    void addOrdersNullTest() {
        //GIVEN
        Product cheese = new Food("Cheese");
        Product meat = new Food("Meat");
        Product salad = new Clothing("Hat");

        ProductDB productDB = new ProductDB(new Product[]{cheese, meat});
        OrderService orderService = new OrderService(productDB);

        //WHEN
        String expected =  "No such products!";
        try {
            orderService.addProductToOrder(salad.getId());
            fail();
        }
        //THEN
        catch (RuntimeException actualException) {
            assertEquals(actualException.getMessage(), expected);
        }
    }

    @Test
    void listOrdersTest() {
        // GIVEN
        Product cheese = new Food("Cheese");
        Product meat = new Food("Meat");
        Product salad = new Food("Salad");

        ProductDB productDB = new ProductDB(new Product[]{cheese, meat, salad});
        OrderService orderService = new OrderService(productDB);

        orderService.addProductToOrder(cheese.getId());
        orderService.addProductToOrder(meat.getId());
        Optional<Order> firstOrder = orderService.getCurrentOrder();
        orderService.completeCurrentOrder();

        orderService.addProductToOrder(cheese.getId());
        Optional<Order> secondOrder = orderService.getCurrentOrder();

        //THEN
        String actual = orderService.listOrders();

        //WHEN
        String expected = "Orders: \n " + firstOrder.get() + " \n " + secondOrder.get() + " \n ";

        assertEquals(expected, actual);
    }
}