package com.eldarchallenge.domain.model;

import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Objects;

import com.sun.istack.NotNull;

import static com.eldarchallenge.domain.model.Utils.ARGENTINA_ZONE_ID;

public class CreditCard {

    //~ Instance Fields ..............................................................................................................................

    @NotNull private CardBrand cardBrand;

    @NotNull private String    cardholder;
    @NotNull private int       cardNumber;
    @NotNull private YearMonth expDate;

    //~ Constructors .................................................................................................................................

    public CreditCard(String cardholder, int cardNumber, YearMonth yearMonth, CardBrand cardBrand) {
        setCardholder(cardholder);
        setCardNumber(cardNumber);
        setExpDate(yearMonth);
        setCardBrand(cardBrand);
    }

    //~ Methods ......................................................................................................................................

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if ((o == null) || (getClass() != o.getClass())) return false;

        final CreditCard that = (CreditCard) o;

        return (cardBrand.equals(that.cardBrand)) && (cardholder.equals(that.cardholder)) && (cardNumber == that.cardNumber) &&
               (expDate == that.expDate);
    }

    @Override public int hashCode() {
        return Objects.hash(cardholder, cardNumber, expDate, cardBrand);
    }

    @Override public String toString() {
        return "Tarjeta " + cardBrand.getBrandName() + "\nNúmero de tarjeta: " + cardNumber + "\nTitular: " + cardholder +
               "\nFecha de vencimiento: " + expDate;
    }

    public CardBrand getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(CardBrand cardBrand) {
        if (cardBrand == null) throw new IllegalArgumentException(Messages.NULL_CARDBRAND.getLabel());
        this.cardBrand = cardBrand;
    }

    public String getCardholder() {
        return cardholder;
    }

    public void setCardholder(@NotNull String cardholder) {
        if (cardholder == null || cardholder.isEmpty()) throw new IllegalArgumentException(Messages.NULL_CARDHOLDER.getLabel());
        this.cardholder = cardholder;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(@NotNull int cardNumber) {
        if (cardNumber <= 0) throw new IllegalArgumentException(Messages.WRONG_CARDNUMBER.getLabel());
        this.cardNumber = cardNumber;
    }

    public boolean isValid() {
        return expDate.isAfter(YearMonth.now(ZoneId.of(ARGENTINA_ZONE_ID)));
    }

    public YearMonth getExpDate() {
        return expDate;
    }

    public void setExpDate(@NotNull YearMonth expDate) {
        if (expDate == null) throw new IllegalArgumentException(Messages.NULL_EXPDATE.getLabel());
        this.expDate = expDate;
    }

    //~ Static Fields ................................................................................................................................

    private static final int    AMMOUNT_MAX_LIMIT = 1000;
    private static final double MAX_SERVICE_RATE  = 5.0;
    private static final double MIN_SERVICE_RATE  = 0.3;
}  // end class CreditCard
