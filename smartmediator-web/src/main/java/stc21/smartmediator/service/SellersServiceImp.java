package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stc21.smartmediator.entity.SellersEntity;
import stc21.smartmediator.repository.OrdersRepository;
import stc21.smartmediator.repository.SellersRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SellersServiceImp implements SellersService {

    @Autowired
    private SellersRepository repository;

    public List findAll() {
        return repository.findAll();
    }

    public Optional<SellersEntity> findById(UUID fromString) {
        return repository.findById(fromString);
    }
}
