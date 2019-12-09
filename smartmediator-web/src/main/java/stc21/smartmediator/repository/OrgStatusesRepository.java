package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.OrgStatusesEntity;

import java.util.UUID;

@Repository
public interface OrgStatusesRepository extends CrudRepository<OrgStatusesEntity, UUID> {
    OrgStatusesEntity findByCode(String aNew);

    // some custom queries

//    List<UserStatusesEntity> search(String query);

//    OrgStatusesEntity findByCode(String code);
}