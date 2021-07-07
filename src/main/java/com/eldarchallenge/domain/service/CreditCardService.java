package com.eldarchallenge.domain.service;

import com.eldarchallenge.domain.dto.OperationDto;
import com.eldarchallenge.domain.dto.OperationResponseDto;
import com.sun.istack.NotNull;

public interface CreditCardService {

    //~ Methods ......................................................................................................................................

    OperationResponseDto getRateServiceOperation(@NotNull OperationDto dto)
        throws IllegalArgumentException;
}
