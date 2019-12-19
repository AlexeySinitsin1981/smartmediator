package stc21.smartmediator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import stc21.smartmediator.entity.OrdersEntity;
import stc21.smartmediator.service.OrdersServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
//@PreAuthorize("hasAuthority('BUYER')")
public class BuyerController {

    @Autowired
    private OrdersServiceImpl service;

    @GetMapping("/buyer")
    public String main(Map<String, Object> model) {
        List orders = service.findAll();
        model.put("orders", orders);

        return "buyer/buyerorders";
    }

    @GetMapping("/buyer/orders/{id}")
    public String editOrder(@PathVariable UUID id, Map<String, Object> model) {
        OrdersEntity order = service.findById(id);
        model.put("order", order);

        return "buyer/showorder";
    }

    @GetMapping("/buyer/bids")
    public String orders(Map<String, Object> model) {

        return "buyer/buyerbids";
    }

//    @GetMapping("/buyer/bids")
//    public String requests(Map<String, Object> model) {
//        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
//        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
//        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
//        userEntorganizationsEntity1.setFullName("Vasia");
//        userEntorganizationsEntity1.setAddress("Люберцы");
//        userEntorganizationsEntity1.setId(new UUID(1, 2));
//        userEntorganizationsEntity2.setId(new UUID(1, 2));
//        userEntorganizationsEntity2.setFullName("Ania");
//        userEntorganizationsEntity2.setAddress("Mosckow");
//        listOfOrganizations.add(userEntorganizationsEntity1);
//        listOfOrganizations.add(userEntorganizationsEntity2);
//        model.put("listOfOrganizations", listOfOrganizations);
//        return "buyer/buyerbids";
//    }

//    @GetMapping("/buyer/history")
//    public String history(Map<String, Object> model) {
//        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
//        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
//        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
//        userEntorganizationsEntity1.setFullName("Vasia");
//        userEntorganizationsEntity1.setAddress("Люберцы");
//        userEntorganizationsEntity1.setId(new UUID(1, 2));
//        userEntorganizationsEntity2.setId(new UUID(1, 2));
//        userEntorganizationsEntity2.setFullName("Ania");
//        userEntorganizationsEntity2.setAddress("Mosckow");
//        listOfOrganizations.add(userEntorganizationsEntity1);
//        listOfOrganizations.add(userEntorganizationsEntity2);
//        model.put("listOfOrganizations", listOfOrganizations);
//
//        return "buyer/buyerhistory";
//    }

//    @GetMapping("/buyer/data")
//    public String data(Map<String, Object> model) {
//        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
//        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
//        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
//        userEntorganizationsEntity1.setFullName("Vasia");
//        userEntorganizationsEntity1.setAddress("Люберцы");
//        userEntorganizationsEntity1.setId(new UUID(1, 2));
//        userEntorganizationsEntity2.setId(new UUID(1, 2));
//        userEntorganizationsEntity2.setFullName("Ania");
//        userEntorganizationsEntity2.setAddress("Mosckow");
//        listOfOrganizations.add(userEntorganizationsEntity1);
//        listOfOrganizations.add(userEntorganizationsEntity2);
//        model.put("listOfOrganizations", listOfOrganizations);
//        return "buyer/buyerdata";
//}

}
