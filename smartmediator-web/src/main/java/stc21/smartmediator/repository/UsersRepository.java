package stc21.smartmediator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stc21.smartmediator.entity.UsersEntity;
import stc21.smartmediator.entity.UsersOrganizationsEntity;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, UUID> {

    UsersEntity findByUsername(String username);

    Optional<UsersEntity> findByEmail(String email);

//    @Transactional
//        default UsersEntity save(UsersEntity user,
//                Iterable<UUID> orgIds,
//                UsersOrganizationsRepository usersOrgRepository) {
//            UsersEntity result = save(user);
//            orgIds.forEach(x -> {
//                UsersOrganizationsEntity userOrg = new UsersOrganizationsEntity(result.getId(), x);
//                usersOrgRepository.save(userOrg);
//            });
//            return result;
//    }
}
