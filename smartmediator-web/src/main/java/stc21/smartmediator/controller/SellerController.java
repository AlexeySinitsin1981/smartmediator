package stc21.smartmediator.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import stc21.smartmediator.entity.OrganizationsEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@PreAuthorize("hasAuthority('SELLER')")
public class SellerController {

    @GetMapping("/seller")
    public String main(Map<String, Object> model) {

        return "seller/sellerhome";
    }

    @GetMapping("/seller/products")
    public String products(Map<String, Object> model) {
        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
        userEntorganizationsEntity1.setFullName("Vasia");
        userEntorganizationsEntity1.setAddress("Люберцы");
        userEntorganizationsEntity1.setId(new UUID(1,2));
        userEntorganizationsEntity2.setId(new UUID(1,2));
        userEntorganizationsEntity2.setFullName("Ania");
        userEntorganizationsEntity2.setAddress("Mosckow");
        listOfOrganizations.add(userEntorganizationsEntity1);
        listOfOrganizations.add(userEntorganizationsEntity2);
        model.put("listOfOrganizations",listOfOrganizations);
        return "seller/sellerproducts";
    }

    @GetMapping("/seller/orders")
    public String orders(Map<String, Object> model) {
        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
        userEntorganizationsEntity1.setFullName("Vasia");
        userEntorganizationsEntity1.setAddress("Люберцы");
        userEntorganizationsEntity1.setId(new UUID(1,2));
        userEntorganizationsEntity2.setId(new UUID(1,2));
        userEntorganizationsEntity2.setFullName("Ania");
        userEntorganizationsEntity2.setAddress("Mosckow");
        listOfOrganizations.add(userEntorganizationsEntity1);
        listOfOrganizations.add(userEntorganizationsEntity2);
        model.put("listOfOrganizations",listOfOrganizations);
        return "seller/sellerorders";
    }
    @GetMapping("/seller/buyers")
    public String buyers(Map<String, Object> model) {
        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
        userEntorganizationsEntity1.setFullName("Vasia");
        userEntorganizationsEntity1.setAddress("Люберцы");
        userEntorganizationsEntity1.setId(new UUID(1,2));
        userEntorganizationsEntity2.setId(new UUID(1,2));
        userEntorganizationsEntity2.setFullName("Ania");
        userEntorganizationsEntity2.setAddress("Mosckow");
        listOfOrganizations.add(userEntorganizationsEntity1);
        listOfOrganizations.add(userEntorganizationsEntity2);
        model.put("listOfOrganizations",listOfOrganizations);
        return "seller/sellerbuyers";
    }

    @GetMapping("/seller/data")
    public String data(Map<String, Object> model) {
        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
        userEntorganizationsEntity1.setFullName("Vasia");
        userEntorganizationsEntity1.setAddress("Люберцы");
        userEntorganizationsEntity1.setId(new UUID(1,2));
        userEntorganizationsEntity2.setId(new UUID(1,2));
        userEntorganizationsEntity2.setFullName("Ania");
        userEntorganizationsEntity2.setAddress("Mosckow");
        listOfOrganizations.add(userEntorganizationsEntity1);
        listOfOrganizations.add(userEntorganizationsEntity2);
        model.put("listOfOrganizations",listOfOrganizations);
        return "seller/sellerdata";
    }




}
