package stc21.smartmediator.dto;

import stc21.smartmediator.entity.ProductsEntity;

import java.util.ArrayList;
import java.util.List;

public class ListOfOrders {
    List<Order> orders;

    public ListOfOrders(List<ProductsEntity> orders) {
        this.orders = new ArrayList<>();
        for (ProductsEntity order : orders) {
            this.orders.add(new Order(order));
        }
    }

    public ListOfOrders() {
        orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
