package org.example.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.entiti.Users;
import org.example.exeption.userException.UserAlreadyExistsException;
import org.example.service.UsersService;
import org.springframework.web.bind.annotation.*;
import org.example.exeption.userException.UserNotFoundException;


@RestController
@RequiredArgsConstructor
@Tag(name = "UserController", description = "Контроллер по работе с пользователями")
@RequestMapping(value = "/manager")
public class UserController {
    public static final String USERS = "/users";
    private final UsersService usersService;

    @GetMapping(USERS)
    public Users getUsers(@RequestParam("login") @Valid String login){
        return usersService.getUserByLogin(login)
                .orElseThrow(() -> new UserNotFoundException("user with " + login + " not found."));
    }

    @PostMapping(USERS)
    public Users createUser(@Valid @RequestBody Users user) {
        if (usersService.getUserByLogin(user.getLogin()).isPresent()){
            throw new UserAlreadyExistsException("User with login " + user.getLogin() + " already exists.");
        }
        return usersService.registerUser(user);
    }

}
