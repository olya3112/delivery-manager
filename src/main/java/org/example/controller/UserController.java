package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.entiti.Users;
import org.example.service.UsersService;
import org.springframework.web.bind.annotation.*;

//import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@Api(tags = {"Методы для получения информации о пользователе"})
@RequestMapping(value = "/manager")
public class UserController {
    public static final String USERS = "/users";
    public static final String CREATE_USERS = "/users";
    public static final String UPDATE_USERS = "/users";

    private final UsersService usersService;

    @GetMapping(USERS)
    @ApiOperation(value = "Метод создания пользователя")
    public Users getUsers(@RequestParam("login") @Valid String login){
        return usersService.getUserByLogin(login);
    }

    @PostMapping(USERS)
    @ApiOperation(value = "Метод создания пользователя")
    public Users createUser(@RequestBody @Valid Users user) {
        return usersService.registerUser(user);
    }

}
