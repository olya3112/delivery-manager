package org.example.repository;

import org.example.entity.Opportunity;
import org.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

//    Optional<Opportunity> findByApplicantId(String applicantId);
    Optional<Opportunity> findByIntegrationId(String integrationId);

    boolean existsByIntegrationId(String integrationId);
}
