package com.eldarchallenge.application.rest;

import com.eldarchallenge.domain.dto.OperationDto;
import com.eldarchallenge.domain.dto.OperationResponseDto;
import com.eldarchallenge.domain.service.CreditCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/rest")
@RestControllerAdvice public class CreditCardRestController {

    //~ Instance Fields ..............................................................................................................................

    private CreditCardService myService;

    //~ Constructors .................................................................................................................................

    @Autowired public CreditCardRestController(CreditCardService myService) {
        this.myService = myService;
    }

    //~ Methods ......................................................................................................................................

    @GetMapping("/operation")
    public OperationResponseDto getRateServiceOperation(@RequestBody(required = false) OperationDto operation) {
        try {
            return myService.getRateServiceOperation(operation);
        }
        catch (final IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }
}
