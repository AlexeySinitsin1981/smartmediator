package stc21.smartmediator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import stc21.smartmediator.entity.OrdersEntity;
import stc21.smartmediator.entity.OrganizationsEntity;
import stc21.smartmediator.service.OrdersServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
//@PreAuthorize("hasAuthority('SELLER')")
public class SellerController {

    @Autowired
    private OrdersServiceImpl service;

    @GetMapping("/seller")
    public String main(Map<String, Object> model) {
        List orders = service.findAll();
        model.put("orders", orders);

        return "seller/sellerorders";
    }

    @GetMapping("/seller/orders/{id}")
    public String editOrder(@PathVariable UUID id, Map<String, Object> model) {
        OrdersEntity order = service.findById(id);
        model.put("order", order);

        return "seller/showorder";
    }

    @GetMapping("/seller/bids")
    public String bids(Map<String, Object> model) {

        return "seller/sellerbids";
    }

}
