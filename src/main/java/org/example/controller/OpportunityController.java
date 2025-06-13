package org.example.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.entity.Opportunity;
import org.example.enums.Currency;
import org.example.exeption.entity.opportunityException.OpportunityNotFoundException;
import org.example.service.OpportunityService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "OpportunityController", description = "Контроллер по работе с заявками")
@RequestMapping(value = "/")
public class OpportunityController {

    public static final String OPPORTUNITY = "/opportunity";

    private final OpportunityService opportunityService;

   @GetMapping(OPPORTUNITY)
    public Opportunity getOpportunity(@RequestParam("integrationId") @Validated String integrationId ){
       return opportunityService.getOpportunityByIntegrationId(integrationId)
               .orElseThrow(() -> new OpportunityNotFoundException("opportunity with " + integrationId + " not found."));
   }


    @PostMapping(OPPORTUNITY)
    public Opportunity createOpportunity( @Validated @RequestBody Opportunity opportunity ){
        return opportunityService.registerOpportunity(opportunity);
    }


}
