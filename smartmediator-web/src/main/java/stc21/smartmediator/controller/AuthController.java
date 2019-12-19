package stc21.smartmediator.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import stc21.smartmediator.entity.RolesEnumEntity;
import stc21.smartmediator.entity.UsersEntity;

import java.util.Map;

@Controller
public class AuthController {

    @GetMapping("/")
    public String main(Map<String, Object> model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();

//        for (RolesEnumEntity u : ((UsersEntity) principal).getRoles()
//        ) {
//            System.out.println(u.toString());
//        }
//        return "redirect:/buyer";

        return "hello";
    }

    @GetMapping("/login")
    public String login(Map<String, Object> model) {

        return "login";
    }

}
