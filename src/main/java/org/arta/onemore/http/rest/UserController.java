package org.arta.onemore.http.rest;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.arta.onemore.database.entity.Role;
import org.arta.onemore.dto.PageResponse;
import org.arta.onemore.dto.UserCreateEditDto;
import org.arta.onemore.dto.UserFilter;
import org.arta.onemore.dto.UserReadDto;
import org.arta.onemore.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RequiredArgsConstructor
@RequestMapping("/users")
@Transactional
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping
    public PageResponse<UserReadDto> findAll(@ModelAttribute UserFilter userFilter, Pageable pageable) {
        return PageResponse.of(userService.findAll(userFilter, pageable));
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
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDto create(@ModelAttribute UserCreateEditDto user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public UserReadDto update(@PathVariable Integer id, @ModelAttribute UserCreateEditDto user) {
        return userService.update(id, user)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if (userService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
