package org.arta.onemore.http.controller;

import org.arta.onemore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sign-in")
@Controller
public class RegistrationController {
    @GetMapping
    public String registration() {
        return "html/registration.html";
    }

    @PostMapping
    public void registration(UserService userService) {

    }
}
