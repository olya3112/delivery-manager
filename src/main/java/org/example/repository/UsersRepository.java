package org.example.repository;

import org.example.entiti.Users;
import org.example.exeption.ManagerInternalException;
import org.example.exeption.enums.ErrorMessageCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByLogin(String login);

    default Users findByLoginOrElseThrow(String login){
        return findByLogin(login)
                .orElseThrow(() ->new ManagerInternalException(ErrorMessageCode.DATA_NOT_FOUND.getCode(),
                        String.format("User with login %s not found!", login)));
    }
}
