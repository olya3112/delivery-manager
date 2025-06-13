package org.example.service;

import jakarta.transaction.Transactional;
import org.example.entity.Users;
import org.example.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Transactional
    public Optional<Users> getUserByLogin(String login) {
        return usersRepository.findByLogin(login);
    }

    public static String generateIntegrationId() {

        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder randomPart = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            randomPart.append(chars.charAt(random.nextInt(chars.length())));
        }

        return datePart + randomPart.toString();
    }


    // Не очень эффективный, надо почитать про айдишники
    @Transactional
    public Users registerUser(Users user) {
        String integrationId;
        do {
            integrationId = generateIntegrationId();
        } while (usersRepository.existsByIntegrationId(integrationId));
        user.setIntegrationId(generateIntegrationId());
        return usersRepository.save(user);
    }
}