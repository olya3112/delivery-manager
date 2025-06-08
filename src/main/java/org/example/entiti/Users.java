package org.example.entiti;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;


@Data
@Entity
@Table(name = "users", schema = "manager")
@Immutable
public class Users {
    @Id
    @Column(name = "login", columnDefinition = "VARCHAR(20)", nullable = true)
    private String login;


    @Column(name = "password", columnDefinition = "VARCHAR(100)", nullable = true)
    private String password;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(20)", nullable = true)
    private String number;

    @Column(name = "email", columnDefinition = "VARCHAR(50)", nullable = true)
    private String email;

}
