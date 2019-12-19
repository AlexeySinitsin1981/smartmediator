package stc21.smartmediator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class AuthController {

    @GetMapping("/")
    public String main(Map<String, Object> model) {

        return "hello";
    }

    @GetMapping("/login")
    public String login(Map<String, Object> model) {

        return "login";
    }

}
