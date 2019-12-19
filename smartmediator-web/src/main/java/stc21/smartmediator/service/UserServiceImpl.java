package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import stc21.smartmediator.entity.OrdersEntity;
import stc21.smartmediator.entity.UsersEntity;
import stc21.smartmediator.repository.RolesRepository;
import stc21.smartmediator.repository.UsersRepository;
import stc21.smartmediator.repository.UserStatusesRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UsersRepository repository;

    @Autowired
    public UserServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user = repository.findByUsername(username);
        return user;
    }

    public List findAll() {
        return repository.findAll();
    }

    public UsersEntity findById(UUID id) {
        Optional<UsersEntity> user = repository.findById(id);
        return user.orElse(null);
    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//
//        UsersEntity user = repository.findByUsername(s);
//        return user;
//    }

//    @Override
//    public List<UsersEntity> findAll() {
//        return repository.findAll();
//    }

//    @Override
//    public UsersEntity findById(String id) {
//        Optional<UsersEntity> usersEntityOptional = repository.findById(UUID.fromString(id));
//
//        return usersEntityOptional.orElse(null);
//    }

//    @Override
//    public UsersEntity searchByEmail(String email) {
//        Optional<UsersEntity> usersEntityOptional = repository.findByEmail(email);
//
//        return usersEntityOptional.orElse(null);
//    }

//    @Override
//    public UsersEntity create(String email, String pass, String full_name) {
//        UsersEntity template = new UsersEntity();
//        template.setEmail(email);
//        template.setPassword(pass);
//        template.setUsername(full_name);
//        template.setStatus(userStatusesRepository.findByCode("new").getId());
//        template.setRole(rolesRepository.findByCode("user").getId());
//
//        return repository.save(new UsersEntity());

//        return null;
//    }
//}

//    @Override
//    public Optional<UsersEntity> create(Map<String, String> params) {
//        String email = params.get("email");
//        String password_hash = params.get("password_hash");
//        String full_name = params.get("full_name");
//        RolesEntity r = rolesRepository.findByCode("user");
//
//        UserStatusesRepository us = userStatusesRepository.findByCode("new");
////        if(r != null && us != null) {
//            return userRepository.save(
//                    new UsersEntity(email, password_hash, full_name, r.getId(), us.getId()));
//        } else {
//            return null;
//        }
//
//        return Optional.empty();
}
