//package stc21.smartmediator;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import stc21.smartmediator.service.Organization;
//import stc21.smartmediator.service.SomeService;
//import stc21.smartmediator.service.User;
//
//import java.util.UUID;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class SomeServiceTest {
//
//    @Autowired
//    private SomeService service;
//
//    @Autowired
//    private User user;
//
//    @Autowired
//    private Organization organization;
//
//    @Test
//    public void CreateUserTest() {
//        String email = UUID.randomUUID() + "@mail.ru";
//        String inn = UUID.randomUUID() + "_inn";
//        service.CreateUser(email, "1", "2", inn, "4", "5", "6");
//        assertNotNull(user.findByEmail(email));
//        assertNotNull(organization.findByInn(inn));
//    }
//}
