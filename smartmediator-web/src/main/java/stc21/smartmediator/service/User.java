package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.entity.OrganizationsEntity;
import stc21.smartmediator.entity.RolesEntity;
import stc21.smartmediator.entity.UserStatusesEntity;
import stc21.smartmediator.entity.UsersEntity;
import stc21.smartmediator.repository.RolesRepository;
import stc21.smartmediator.repository.UserStatusesRepository;
import stc21.smartmediator.repository.UsersOrganizationsRepository;
import stc21.smartmediator.repository.UsersRepository;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;


@Component
public class User {

    public final String emailFieldName = "email";
    public final String fullNameFieldName = "full_name";
    public final String passwordHashFieldName = "password_hash";
    public final String statusFieldName = "status";

    private final UsersRepository repository;
    private final UsersOrganizationsRepository userOrgRepository;
    private final RolesRepository rolesRepository;
    private final UserStatusesRepository userStatusesRepository;
    private final TraceOrder traceOrder;

    @Autowired
    public User(UsersRepository repository,
                UsersOrganizationsRepository userOrgRepository,
                RolesRepository rolesRepository,
                UserStatusesRepository userStatusesRepository, TraceOrder traceOrder) {
        this.repository = repository;
        this.userOrgRepository = userOrgRepository;

        this.rolesRepository = rolesRepository;
        this.userStatusesRepository = userStatusesRepository;
        this.traceOrder = traceOrder;
    }

    private UUID userRoleId;
    private UUID getUserRoleId() {
        if(userRoleId == null) {
            RolesEntity r = rolesRepository.findByCode("user");
            userRoleId = r.getId();
        }
        return userRoleId;
    }

    private UUID newStatusId;
    private UUID getNewStatusId() {
        if(newStatusId == null) {
            UserStatusesEntity us = userStatusesRepository.findByCode("new");
            newStatusId = us.getId();
        }
        return newStatusId;
    }

//    public UsersEntity create(String email,
//                              String passwordHash,
//                              String name,
//                              Collection<OrganizationsEntity> organizations) {
//        UsersEntity newUser = new UsersEntity(email, passwordHash, name, getNewStatusId(), true);
//        List<UUID> orgIds = organizations.stream().map(x -> x.getId()).collect(Collectors.toList());
//        return repository.save(newUser, orgIds, userOrgRepository);
//    }

    public UsersEntity get(UUID id) {
        Optional<UsersEntity> user = repository.findById(id);
        return user.orElse(null);
    }

    public UsersEntity findByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    public ArrayList<UsersEntity> getAll() {
        Iterable<UsersEntity> users = repository.findAll();
        ArrayList<UsersEntity> userList = new ArrayList<>();
        users.forEach(userList::add);
        return userList;
    }

    public UsersEntity update(UUID id, Map<String, String> fields) {

        UsersEntity user = repository.findById(id).orElse(null);
        if(user == null) {
            throw new IllegalStateException("User with id = " + id + " not found.");
        }

        String email = fields.get(emailFieldName);
        if(email != null) {
            user.setEmail(email);
        }

        String password = fields.get(passwordHashFieldName);
        if(password != null) {
            user.setPassword(password);
        }

        String name = fields.get(fullNameFieldName);
        if(name != null) {
            user.setUsername(name);
        }

        String status = fields.get(statusFieldName);
        if(status != null) {
            UserStatusesEntity s = userStatusesRepository.findByCode(status);
            if(s != null) {
                user.setStatus(s.getId());
            }
        }
        return repository.save(user);
    }

    @Transactional
    public void delete(UUID id) {
        userOrgRepository.deleteAllByUserId(id);
        traceOrder.deleteByAuthor(id);
        repository.deleteById(id);
    }
}
