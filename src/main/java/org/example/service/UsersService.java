package org.example.service;

import jakarta.transaction.Transactional;
import org.example.entiti.Users;
import org.example.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Transactional
    public Users getUserByLogin(String login) {
        return usersRepository.findByLoginOrElseThrow(login);
    }


    @Transactional
    public Users registerUser(Users user) {
        return usersRepository.save(user);
    }
}