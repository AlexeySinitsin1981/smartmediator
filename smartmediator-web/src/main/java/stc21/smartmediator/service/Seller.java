package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.entity.OrganizationsEntity;
import stc21.smartmediator.entity.SellersEntity;
import stc21.smartmediator.repository.SellersRepository;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class Seller {

    private final SellersRepository repository;
    private final PricePattern pricePattern;
    private final Product product;
    private final Order order;
    private final ExternalLink externalLink;

    @Autowired
    public Seller(SellersRepository repository,
                  PricePattern pricePattern,
                  Product product, Order order, ExternalLink externalLink) {
        this.repository = repository;
        this.pricePattern = pricePattern;
        this.product = product;
        this.order = order;
        this.externalLink = externalLink;
    }

    public SellersEntity create(OrganizationsEntity organization) {
        SellersEntity newSeller = new SellersEntity(organization);
        return repository.save(newSeller);
    }

    public SellersEntity get(UUID id) {
        Optional<SellersEntity> seller = repository.findById(id);
        return seller.orElse(null);
    }

    public ArrayList<SellersEntity> getAll() {
        Iterable<SellersEntity> sellers = repository.findAll();
        ArrayList<SellersEntity> userList = new ArrayList<>();
        sellers.forEach(userList::add);
        return userList;
    }

    @Transactional
    public int deleteAllByOrgId(UUID orgId) {
        Collection<SellersEntity> sellers = repository.findByOrgId(orgId);
        sellers.forEach(
                x -> delete(x.getId()));
        return sellers.size();
    }

    @Transactional
    public void delete(UUID id) {
        product.deleteAllBySellerId(id);
        pricePattern.deleteAllBySellerId(id);
        order.deleteBySellerId(id);
        externalLink.deleteBySellerId(id);
        repository.deleteById(id);
    }
}
