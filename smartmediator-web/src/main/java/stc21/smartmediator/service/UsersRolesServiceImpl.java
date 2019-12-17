package stc21.smartmediator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stc21.smartmediator.repository.UsersRolesRepository;

@Service
public class UsersRolesServiceImpl implements UsersRolesService {
//public class UsersRolesServiceImpl {

    @Autowired
    private UsersRolesRepository repository;

    public UsersRolesServiceImpl(UsersRolesRepository repository) {
        this.repository = repository;
    }
}
