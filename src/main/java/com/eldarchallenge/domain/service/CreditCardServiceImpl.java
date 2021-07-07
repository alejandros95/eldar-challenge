package com.eldarchallenge.domain.service;

import java.time.YearMonth;

import com.eldarchallenge.domain.dto.CreditCardDto;
import com.eldarchallenge.domain.dto.OperationDto;
import com.eldarchallenge.domain.dto.OperationResponseDto;
import com.eldarchallenge.domain.model.CardBrand;
import com.eldarchallenge.domain.model.CreditCard;
import com.eldarchallenge.domain.model.Messages;
import com.eldarchallenge.domain.model.Operation;
import com.sun.istack.NotNull;

import org.springframework.stereotype.Service;

@Service public class CreditCardServiceImpl implements CreditCardService {

    //~ Methods ......................................................................................................................................

    @Override public OperationResponseDto getRateServiceOperation(OperationDto dto)
        throws IllegalArgumentException
    {
        final double        ammount       = dto.getAmmount();
        final CreditCardDto creditCardDto = dto.getCreditCard();
        final CardBrand     cardBrand     = getCardBrand(creditCardDto.getCardBrand());
        final YearMonth     yearMonth     = YearMonth.of(creditCardDto.getExpYear(), creditCardDto.getExpMonth());
        final CreditCard    creditCard    = new CreditCard(creditCardDto.getCardholder(), creditCardDto.getCardNumber(), yearMonth, cardBrand);
        if (!creditCard.isValid()) throw new IllegalArgumentException(Messages.EXPIRED_CARD.getLabel());

        final Operation operation = new Operation(ammount, creditCard);
        if (!operation.isValid()) throw new IllegalArgumentException(Messages.AMMOUNT_EXCEEDS_LIMIT.getLabel());

        return new OperationResponseDto(creditCard.getCardBrand().getBrandName(), operation.getTotalAmmount(), operation.getBrandRateService());
    }

    CardBrand getCardBrand(@NotNull String brand) {
        switch (brand.toUpperCase()) {
        case "VISA":
            return CardBrand.Visa.INSTANCE.getInstance();
        case "AMEX":
            return CardBrand.Amex.INSTANCE.getInstance();
        case "NARA":
            return CardBrand.Nara.INSTANCE.getInstance();
        default:
            throw new IllegalArgumentException(Messages.INVALID_BRAND_NAME.getLabel());
        }
    }
}
