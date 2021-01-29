package de.neuefische.order;

import de.neuefische.product.Product;

import java.util.*;

public class OrderDB {

    private final HashMap<Integer, Order> orders = new HashMap<>();


    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public Optional<Order> getOrder(Integer orderId) {
        if (orders.containsKey(orderId)) {
            return Optional.of(orders.get(orderId));
        }
        return Optional.empty();
    }

    public List<Order> getOrderList() {
        List<Order> result = new ArrayList<>(orders.values());
        return result;
    }





}
