//package stc21.smartmediator;
//
//import org.hibernate.Session;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import stc21.smartmediator.entity.UsersEntity;
//import stc21.smartmediator.entity.UsersOrganizationsEntity;
//import stc21.smartmediator.repository.*;
//import stc21.smartmediator.service.User;
//
//import java.util.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//@AutoConfigureMockMvc
//public class UsersRepositoryTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private UsersRepository repository;
//
//    @Autowired
//    private UsersOrganizationsRepository userOrgRepository;
//
//    @Autowired
//    private OrganizationsRepository orgRepository;
//
//    @Autowired
//    private RolesRepository rolesRepository;
//
//    @Autowired
//    private UserStatusesRepository userStatusesRepository;
//
//    @Autowired
//    private User user;
//
//    @Test
//    public void userSaveTest(){
//        UUID status_id = userStatusesRepository.findByCode("new").getId();
//        UUID role_id = rolesRepository.findByCode("user").getId();
//        UsersEntity newUser = new UsersEntity(
//                UUID.randomUUID() + "test", "test", "userSaveTest",
////                role_id,
//                status_id, true);
//        ArrayList<UUID> orgIds = new ArrayList<>();
//        orgRepository.findAll().forEach(x -> orgIds.add(x.getId()));
//        UUID user_id = repository.save(newUser, orgIds, userOrgRepository).getId();
//
//        Iterable<UsersOrganizationsEntity> userOrgs = userOrgRepository.findAllByUserId(user_id);
//        AtomicInteger count = new AtomicInteger();
//        userOrgs.forEach(x -> {
//            assertEquals(user_id, x.getUserId());
//            count.getAndIncrement();
//        });
//
//        assertEquals(orgIds.size(), count.get());
//
//        user.delete(user_id);
//
//        Iterable<UsersOrganizationsEntity> uo = userOrgRepository.findAllByUserId(user_id);
//        assertFalse(uo.iterator().hasNext());
//
//        Optional<UsersEntity> empty_user = repository.findById(user_id);
//        assertFalse(empty_user.isPresent());
//    }
//
//    @Test
//    public void userSaveWrongOrganizationTest(){
//        UUID status_id = userStatusesRepository.findByCode("new").getId();
//        UUID role_id = rolesRepository.findByCode("user").getId();
//        String email = UUID.randomUUID() + "@gmail.com";
//        UsersEntity user = new UsersEntity(
//                email,
//                "test",
//                "userSaveWrongOrganizationTest",
////                role_id,
//                status_id, true);
//        List<UUID> orgIds =  Collections.singletonList(UUID.randomUUID());
//
//        try {
//            repository.save(user, orgIds, userOrgRepository);
//        } catch (DataIntegrityViolationException e) {
//                e.printStackTrace();
//        }
//
//        Optional<UsersEntity> empty_user = repository.findByEmail(email);
//        assertFalse(empty_user.isPresent());
//    }
//}
