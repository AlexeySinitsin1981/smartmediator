package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stc21.smartmediator.entity.OrdersEntity;
import stc21.smartmediator.repository.OrdersRepository;
import stc21.smartmediator.repository.UsersRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository repository;

    public OrdersServiceImpl(OrdersRepository repository) {

        this.repository = repository;
    }

    public List findAll() {
        return repository.findAll();
    }

    public OrdersEntity findById(UUID id) {
        Optional<OrdersEntity> order = repository.findById(id);
        return order.orElse(null);
    }
}
