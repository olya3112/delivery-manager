package org.example.exeption.entity.opportunityException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OpportunityNotFoundException extends RuntimeException  {

    public OpportunityNotFoundException(String exeption){
        super(exeption);
    }
}
