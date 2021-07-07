package com.eldarchallenge.domain.dto;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @Builder @Getter @NoArgsConstructor @Setter public class OperationDto {

    //~ Instance Fields ..............................................................................................................................

    @NotNull private double        ammount;
    @NotNull private CreditCardDto creditCard;
}
