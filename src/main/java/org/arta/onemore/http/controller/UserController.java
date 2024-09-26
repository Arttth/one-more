package org.arta.onemore.http.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.arta.onemore.database.entity.Role;
import org.arta.onemore.database.repository.UserRepository;
import org.arta.onemore.dto.UserCreateEditDto;
import org.arta.onemore.dto.UserFilter;
import org.arta.onemore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RequestMapping("/users")
@Transactional
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping
    public String findAll(Model model, @ModelAttribute UserFilter filter) {
        model.addAttribute("users", userService.findAll(filter));
        return "user/users";
    }
    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id, Model model) {
        return userService.findById(id)
                        .map(it -> {
                            model.addAttribute("user", it);
                            model.addAttribute("roles", Role.values());
                            return "user/user";
                        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public String create(@ModelAttribute UserCreateEditDto user) {
        userService.create(user);
        return "redirect:user/" + 0;
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id, @ModelAttribute UserCreateEditDto user) {
        userService.update(id, user);
        return "redirect:/users/{id}";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
