//package stc21.smartmediator.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import stc21.smartmediator.entity.OrganizationsEntity;
//import stc21.smartmediator.entity.UsersEntity;
//
//import java.util.Collections;
//
//@Service
//public class SomeService {
//
//    private final User user;
//    private final Organization organization;
//
//    @Autowired
//    public SomeService(User user, Organization organization) {
//        this.user = user;
//        this.organization = organization;
//    }
//
//    public UsersEntity CreateUser(String email,
//                                  String name,
//                                  String passwordHash,
//                                  String inn,
//                                  String orgFullName,
//                                  String orgName,
//                                  String orgAddress) {
//
//        OrganizationsEntity org = organization.findByInn(inn);
//
//        if(org == null) {
//            org = organization.create(orgFullName, orgName, inn, orgAddress);
//        }
//
//        return user.create(email, passwordHash, name, Collections.singleton(org));
//    }
//}
