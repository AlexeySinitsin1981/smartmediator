package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.OrdersEntity;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, UUID> {

    Collection<OrdersEntity> findAllBySellerId(UUID id);

    Collection<OrdersEntity> findAllByBuyerId(UUID id);

    List findAllByDeleted(int i);


}
