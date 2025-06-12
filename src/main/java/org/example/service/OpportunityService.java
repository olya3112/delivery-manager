package org.example.service;

import io.netty.util.collection.ByteCollections;
import jakarta.transaction.Transactional;
import org.example.entity.Opportunity;
import org.example.entity.Users;
import org.example.enums.Currency;
import org.example.repository.OpportunityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;

@Service
public class OpportunityService {

    private final OpportunityRepository opportunityRepository;

    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    @Transactional
    public Optional<Opportunity> getOpportunityByIntegrationId(String integrationId) {
        return opportunityRepository.findByIntegrationId(integrationId);
    }


    // генерируем интеграционный айдишник для заявки
    public static String generateIntegrationId() {

        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder randomPart = new StringBuilder(10);
        for (int i = 0; i < 6; i++) {
            randomPart.append(chars.charAt(random.nextInt(chars.length())));
        }

        return datePart + "-" + randomPart.toString();
    }

    @Transactional
    public Opportunity registerOpportunity(Opportunity opportunity) {
        String integrationId;

        if (!Currency.containsValue(opportunity.getCurrency())) {
            throw new IllegalArgumentException("Currency " + opportunity.getCurrency() + " is not valid.");
        }

        do {
            integrationId = generateIntegrationId();
        } while (opportunityRepository.existsByIntegrationId(integrationId));
        opportunity.setIntegrationId(generateIntegrationId());
        return opportunityRepository.save(opportunity);
    }
}
