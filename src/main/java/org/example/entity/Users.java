package org.example.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
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

    @Pattern(regexp = "^8\\(\\d{3}\\)-\\d{3}-\\d{2}-\\d{2}$")
    @Column(name = "phone_number", columnDefinition = "VARCHAR(20)", nullable = true)
    private String number;

    @Email
    @Column(name = "email", columnDefinition = "VARCHAR(50)", nullable = true)
    private String email;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "integration_id", columnDefinition = "VARCHAR(20)", nullable = true)
    private String integrationId;


}
