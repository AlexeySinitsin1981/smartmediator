package stc21.smartmediator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import stc21.smartmediator.entity.OrdersEntity;
import stc21.smartmediator.entity.UsersEntity;
import stc21.smartmediator.service.OrdersServiceImpl;
import stc21.smartmediator.service.UserServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private OrdersServiceImpl service;

    @GetMapping("/admin")
    public String main(Map<String, Object> model) {
        List<UsersEntity> users = userService.findAll();
        model.put("users", users);

        return "admin/adminusers";
    }

    @GetMapping("/admin/users/{id}")
    public String editUser(@PathVariable UUID id, Map<String, Object> model) {
        UsersEntity user = userService.findById(id);
        model.put("user", user);

        return "admin/showuser";
    }

    @GetMapping("/admin/users/create")
    public String createUser(Map<String, Object> model) {

        return "admin/createuser";
    }

    @GetMapping("/admin/orders")
    public String orders(Map<String, Object> model) {
        List orders = service.findAll();
        model.put("orders", orders);

        return "admin/adminorders";
    }

    @GetMapping("/admin/orders/{id}")
    public String editOrder(@PathVariable UUID id, Map<String, Object> model) {
        OrdersEntity order = service.findById(id);
        model.put("order", order);

        return "admin/showorder";
    }

    @PostMapping("/admin/changePassword")
    public String changePassword(@PathVariable UUID id, Map<String, Object> model) {
        return "admin/showorder";
    }

    @PostMapping("/admin/saveDataUser")
    public String saveDataUser(@PathVariable UUID id, Map<String, Object> model) {
        return "admin/showorder";
    }

//    @GetMapping("/admin/buyers/formCreateBuyer")
//    public String formCreateUser(Model model) {
//        return "admin/admincreatebuyer";
//    }
//
//    @GetMapping("/admin/buyers/createUser")
//    public String createBuyer(@ModelAttribute("OrganizationsEntity") OrganizationsEntity organizationsEntity) {
//        String name = organizationsEntity.getFullName();
//        //Создать организацию и сохранить в базу
//        OrganizationsEntity organisation = new OrganizationsEntity();
//        return "redirect:/admin/buyers";
//    }
//
//    @GetMapping("/admin/buyers/{id}")
//    public String buyersEdit(@PathVariable UUID id, Model model) {
//        OrganizationsEntity organisation = new OrganizationsEntity();
//        //Получить организацию по ID
//        organisation.setId(new UUID(1, 2));
//        organisation.setFullName("Vladimir");
//        model.addAttribute("organisation", organisation);
//        return "admin/admineditbuyer";
//    }
//
//    @GetMapping("/admin/buyers/saveUser/{id}")
//    public String saveBuyer(@PathVariable UUID id, @ModelAttribute("OrganizationsEntity") OrganizationsEntity organizationsEntity) {
//        String name = organizationsEntity.getFullName();
//        OrganizationsEntity organisation = new OrganizationsEntity();
//        //Получить организацию по ID и сохранить в базу
//        return "redirect:/admin/buyers";
//    }
//
//    @GetMapping("/admin/buyers/deleteUser/{id}")
//    public String deleteBuyer(@PathVariable UUID id, @ModelAttribute("OrganizationsEntity") OrganizationsEntity organizationsEntity) {
//        String idN = id.toString();
//        //Удалить организацию
//        return "redirect:/admin/buyers";
//    }
//
//
//    @GetMapping("/admin/sellers")
//    public String sellers(Model model) {
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
//        model.addAttribute("listOfOrganizations", listOfOrganizations);
//        return "admin/adminsellers";
//    }
//
//    @GetMapping("/admin/sellers/formCreateSeller")
//    public String formCreateSeller(Model model) {
//        return "admin/admincreateseller";
//    }
//
//    @GetMapping("/admin/sellers/createUser")
//    public String createSeller(@ModelAttribute("OrganizationsEntity") OrganizationsEntity organizationsEntity) {
//        String name = organizationsEntity.getFullName();
//        //Создать организацию и сохранить в базу
//        OrganizationsEntity organisation = new OrganizationsEntity();
//        return "redirect:/admin/sellers";
//    }
//
//    @GetMapping("/admin/sellers/{id}")
//    public String sellersEdit(@PathVariable UUID id, Model model) {
//        OrganizationsEntity organisation = new OrganizationsEntity();
//        //Получить организацию по ID
//        organisation.setId(new UUID(1, 2));
//        organisation.setFullName("Vladimir");
//        model.addAttribute("organisation", organisation);
//        return "admin/admineditseller";
//    }
//
//    @GetMapping("/admin/sellers/saveUser/{id}")
//    public String saveSeller(@PathVariable UUID id, @ModelAttribute("OrganizationsEntity") OrganizationsEntity organizationsEntity) {
//        String name = organizationsEntity.getFullName();
//        OrganizationsEntity organisation = new OrganizationsEntity();
//        //Получить организацию по ID и сохранить в базу
//        return "redirect:/admin/sellers";
//    }
//
//    @GetMapping("/admin/sellers/deleteUser/{id}")
//    public String deleteSeller(@PathVariable UUID id, @ModelAttribute("OrganizationsEntity") OrganizationsEntity organizationsEntity) {
//        String idN = id.toString();
//        //Удалить организацию
//        return "redirect:/admin/sellers";
//    }

}
