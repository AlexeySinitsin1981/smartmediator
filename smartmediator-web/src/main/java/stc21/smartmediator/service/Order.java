package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.entity.*;
import stc21.smartmediator.repository.OrdersRepository;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class Order {

    private final String noteFieldName = "note";

    private final OrdersRepository repository;
    private final TraceOrder traceOrder;
    private final OrderProduct orderProduct;

    @Autowired
    public Order(OrdersRepository repository, TraceOrder traceOrder, OrderProduct orderProduct) {
        this.repository = repository;
        this.traceOrder = traceOrder;
        this.orderProduct = orderProduct;
    }

//    public OrdersEntity create(OrderStatusesEntity status,
//                               BuyersEntity buyer,
//                               SellersEntity seller,
//                               DeliveryTypesEntity deliveryType,
//                               PricePatternsEntity price,
//                               LogisticsPointsEntity sourcePoint,
//                               LogisticsPointsEntity destPoint,
//                               String note) {
//        OrdersEntity order = new OrdersEntity(
//                note,
//                //FIXME:
//                status,
//                buyer.getId(),
//                seller.getId(),
//                deliveryType.getId(),
//                price.getId(),
//                sourcePoint.getId(),
//                destPoint.getId());
//        return repository.save(order);
//    }

    public OrdersEntity get(UUID id) {
        Optional<OrdersEntity> order = repository.findById(id);
        return order.orElse(null);
    }

    public ArrayList<OrdersEntity> getAll() {
        Iterable<OrdersEntity> order = repository.findAll();
        ArrayList<OrdersEntity> orderList = new ArrayList<>();
        order.forEach(orderList::add);
        return orderList;
    }

    public OrdersEntity update(UUID id, Map<String, String> fields) {

        OrdersEntity order = repository.findById(id).orElse(null);
        if(order == null) {
            throw new IllegalStateException("Order with id = " + id + " not found.");
        }

        String note = fields.get(noteFieldName);
        if(note != null) {
            order.setNote(note);
        }

        return repository.save(order);
    }

    @Transactional
    public int deleteBySellerId(UUID sellerId) {
        Collection<OrdersEntity> orders = repository.findAllBySellerId(sellerId);
        orders.forEach(
                x -> delete(x.getId()));
        return orders.size();
    }

    @Transactional
    public int deleteByBuyerId(UUID buyerId) {
        Collection<OrdersEntity> orders = repository.findAllByBuyerId(buyerId);
        orders.forEach(
                x -> delete(x.getId()));
        return orders.size();
    }

    @Transactional
    public void delete(UUID id) {
        traceOrder.deleteByOrderId(id);
        orderProduct.deleteByOrderId(id);
        repository.deleteById(id);
    }

}
