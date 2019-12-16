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
//@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @GetMapping("/admin")
    public String main(Map<String, Object> model) {

        return "admin/adminHome";
    }

    @GetMapping("/admin/orders")
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
        return "admin/adminorders";
    }

    @GetMapping("/admin/bids")
    public String bids(Map<String, Object> model) {
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
        return "admin/adminbids";
    }

    @GetMapping("/admin/buyers")
    public String buyers(Model model) {
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
        model.addAttribute("listOfOrganizations",listOfOrganizations);
        return "admin/adminbuyers";
    }

    @GetMapping("/admin/buyers/formCreateBuyer")
    public String formCreateUser(Model model) {
        return "admin/admincreatebuyer";
    }

    @GetMapping("/admin/buyers/createUser")
    public String createBuyer(@ModelAttribute("OrganizationsEntity") OrganizationsEntity organizationsEntity) {
        String name=organizationsEntity.getFullName();
        //Создать организацию и сохранить в базу
        OrganizationsEntity organisation = new OrganizationsEntity();
        return "redirect:/admin/buyers";
    }

    @GetMapping("/admin/buyers/{id}")
    public String buyersEdit(@PathVariable UUID id, Model model) {
        OrganizationsEntity organisation = new OrganizationsEntity();
        //Получить организацию по ID
        organisation.setId(new UUID(1,2));
        organisation.setFullName("Vladimir");
        model.addAttribute("organisation",organisation);
        return "admin/admineditbuyer";
    }

    @GetMapping("/admin/buyers/saveUser/{id}")
    public String saveBuyer(@PathVariable UUID id, @ModelAttribute("OrganizationsEntity") OrganizationsEntity organizationsEntity) {
        String name=organizationsEntity.getFullName();
        OrganizationsEntity organisation = new OrganizationsEntity();
        //Получить организацию по ID и сохранить в базу
        return "redirect:/admin/buyers";
    }

    @GetMapping("/admin/buyers/deleteUser/{id}")
    public String deleteBuyer(@PathVariable UUID id, @ModelAttribute("OrganizationsEntity") OrganizationsEntity organizationsEntity) {
        String idN=id.toString();
        //Удалить организацию
        return "redirect:/admin/buyers";
    }



    @GetMapping("/admin/sellers")
    public String sellers(Model model) {
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
        model.addAttribute("listOfOrganizations",listOfOrganizations);
        return "admin/adminsellers";
    }

    @GetMapping("/admin/sellers/formCreateSeller")
    public String formCreateSeller(Model model) {
        return "admin/admincreateseller";
    }

    @GetMapping("/admin/sellers/createUser")
    public String createSeller(@ModelAttribute("OrganizationsEntity") OrganizationsEntity organizationsEntity) {
        String name=organizationsEntity.getFullName();
        //Создать организацию и сохранить в базу
        OrganizationsEntity organisation = new OrganizationsEntity();
        return "redirect:/admin/sellers";
    }

    @GetMapping("/admin/sellers/{id}")
    public String sellersEdit(@PathVariable UUID id, Model model) {
        OrganizationsEntity organisation = new OrganizationsEntity();
        //Получить организацию по ID
        organisation.setId(new UUID(1,2));
        organisation.setFullName("Vladimir");
        model.addAttribute("organisation",organisation);
        return "admin/admineditseller";
    }

    @GetMapping("/admin/sellers/saveUser/{id}")
    public String saveSeller(@PathVariable UUID id, @ModelAttribute("OrganizationsEntity") OrganizationsEntity organizationsEntity) {
        String name=organizationsEntity.getFullName();
        OrganizationsEntity organisation = new OrganizationsEntity();
        //Получить организацию по ID и сохранить в базу
        return "redirect:/admin/sellers";
    }

    @GetMapping("/admin/sellers/deleteUser/{id}")
    public String deleteSeller(@PathVariable UUID id, @ModelAttribute("OrganizationsEntity") OrganizationsEntity organizationsEntity) {
        String idN=id.toString();
        //Удалить организацию
        return "redirect:/admin/sellers";
    }

}
