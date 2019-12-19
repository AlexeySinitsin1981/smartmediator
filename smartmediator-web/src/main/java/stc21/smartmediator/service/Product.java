package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.entity.*;
import stc21.smartmediator.repository.ProductsRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Component
public class Product {

    private final String codeFieldName = "code";
    private final String nameFieldName = "name";
    private final String quantityFieldName = "quantity";
    private final String noteFieldName = "note";
    private final String deletedFieldName = "deleted";

    private final ProductsRepository repository;
    private final OrderProduct orderProduct;
    private final ExternalLink externalLink;
    private final Price price;

    @Autowired
    public Product(ProductsRepository repository, OrderProduct orderProduct, ExternalLink externalLink, Price price) {
        this.repository = repository;
        this.orderProduct = orderProduct;
        this.externalLink = externalLink;
        this.price = price;
    }

    public ProductsEntity create(String code,
                                 String name,
                                 BigDecimal address,
                                 String note,
                                 UnitsEntity unit,
                                 ProductsTypesEntity productType,
                                 SellersEntity seller) {
        ProductsEntity product = new ProductsEntity(
                code, name, address, note, unit, productType.getId(), seller.getId());
        return repository.save(product);
    }

    public ProductsEntity get(UUID id) {
        Optional<ProductsEntity> product = repository.findById(id);
        return product.orElse(null);
    }

    public ArrayList<ProductsEntity> getAll() {
        Iterable<ProductsEntity> product = repository.findAll();
        ArrayList<ProductsEntity> productList = new ArrayList<>();
        product.forEach(productList::add);
        return productList;
    }

    public ProductsEntity update(UUID id, Map<String, String> fields) {

        ProductsEntity product = repository.findById(id).orElse(null);
        if(product == null) {
            throw new IllegalStateException("Product with id = " + id + " not found.");
        }

        String code = fields.get(codeFieldName);
        if(code != null) {
            product.setCode(code);
        }

        String name = fields.get(nameFieldName);
        if(name != null) {
            product.setName(name);
        }

        String quantity = fields.get(quantityFieldName);
        if(quantity != null) {
            product.setQuantity(BigDecimal.valueOf(Long.valueOf(quantity)));
        }

        String note = fields.get(noteFieldName);
        if(note != null) {
            product.setName(note);
        }

        String deleted = fields.get(deletedFieldName);
        if(deleted != null) {
            product.setDeleted(Boolean.parseBoolean(deleted));
        }
        return repository.save(product);
    }

    @Transactional
    public int deleteAllBySellerId(UUID sellerId) {
        Collection<ProductsEntity> products = repository.findAllBySellerId(sellerId);
        products.forEach(x -> delete(x.getId()));
        return products.size();
    }

    @Transactional
    public void delete(UUID id) {
        price.deleteAllByProductId(id);
        orderProduct.deleteAllByProductId(id);
        externalLink.deleteAllByProductId(id);
        repository.deleteById(id);
    }
}
