package org.example.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "opportunity", schema = "manager",
        uniqueConstraints = @UniqueConstraint(name = "opportunity_integration_id_key", columnNames = "integration_id"))
public class Opportunity {

    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "integration_id", length = 20, nullable = false, unique = true)
    private String integrationId;

    @Column(name = "bic", length = 9, nullable = false)
    private String bic;

    @Column(name = "currency", length = 10, nullable = false)
    private String currency;

    @Column(name = "application_id", length = 20, nullable = false)
    private String applicationId;
}
