package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stc21.smartmediator.repository.OrdersRepository;

import java.util.List;

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
}
