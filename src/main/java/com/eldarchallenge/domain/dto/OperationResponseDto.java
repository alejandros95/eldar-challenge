package com.eldarchallenge.domain.dto;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @Builder @Getter @NoArgsConstructor @Setter public class OperationResponseDto {

    //~ Instance Fields ..............................................................................................................................

    @NotNull private String cardBrand;
    @NotNull private double rateServiceBrand;
    @NotNull private double totalAmmount;
}
