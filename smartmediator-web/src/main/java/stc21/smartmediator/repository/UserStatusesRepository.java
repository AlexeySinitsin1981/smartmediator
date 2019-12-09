package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.UserStatusesEntity;

import java.util.UUID;

@Repository
public interface UserStatusesRepository extends CrudRepository<UserStatusesEntity, UUID> {
    UserStatusesEntity findByCode(String aNew);

//    UserStatusesEntity findByCode(String code);

}
