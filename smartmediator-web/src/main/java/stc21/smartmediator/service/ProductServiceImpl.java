package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stc21.smartmediator.entity.ProductsEntity;
import stc21.smartmediator.repository.ProductsRepository;
import stc21.smartmediator.repository.SellersRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductsRepository repository;
    public List findAll() {
        return repository.findAll();
    }

    public List<ProductsEntity> findAllBySellerId(String uuid) {

        return (List<ProductsEntity>) repository.findAllBySellerId(UUID.fromString(uuid));
    }

}
