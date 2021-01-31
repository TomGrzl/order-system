package de.neuefische;

import de.neuefische.order.Order;
import de.neuefische.order.OrderDB;
import de.neuefische.product.Product;
import de.neuefische.product.ProductDB;

import java.util.Collection;
import java.util.Optional;

public class OrderService {

    private OrderDB orderDB = new OrderDB();
    private ProductDB productDB;

    private Order currentOrder;

    public OrderService(ProductDB productDB) {
        this.productDB = productDB;
    }

    public void addProductToOrder(int productID) throws RuntimeException {
        if (currentOrder == null) {
            currentOrder = new Order();
            orderDB.addOrder(currentOrder);
        }

        Optional<Product> orderedProduct = productDB.getProduct(productID);
        if (orderedProduct.equals(Optional.empty())) {
            throw new RuntimeException("No such products!");
        } else {
            currentOrder.add(orderedProduct.get());
        }
    }

    public void completeCurrentOrder() {
        currentOrder = null;
    }

    public Optional<Order> getCurrentOrder() {
        if(currentOrder == null)
            return  Optional.empty();
        return  Optional.of(currentOrder);
    }

    public String listOrders() {
        StringBuilder result = new StringBuilder("Orders: \n ");
        Collection<Order> orders = orderDB.getOrderList();

        for (Order order : orders) {
            result.append(order).append(" \n ");
        }

        return result.toString();
    }
}
