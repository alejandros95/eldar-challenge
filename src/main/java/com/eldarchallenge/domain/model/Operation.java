
package com.eldarchallenge.domain.model;

import com.sun.istack.NotNull;

public class Operation {

    //~ Instance Fields ..............................................................................................................................

    @NotNull private double     ammount;
    @NotNull private CreditCard creditCard;

    //~ Constructors .................................................................................................................................

    public Operation(double ammount, CreditCard creditCard) {
        setAmmount(ammount);
        setCreditCard(creditCard);
    }

    //~ Methods ......................................................................................................................................

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        if (ammount <= 0) throw new IllegalArgumentException(Messages.WRONG_AMMOUNT.getLabel());
        this.ammount = ammount;
    }

    public double getBrandRateService() {
        return (getCreditCard().getCardBrand().getServiceRate() * getAmmount()) / 100;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        if (creditCard == null) throw new IllegalArgumentException(Messages.NULL_CREDITCARD.getLabel());
        this.creditCard = creditCard;
    }

    public boolean isValid() {
        return getAmmount() > MIN_LIMIT_AMMOUNT && getAmmount() < MAX_LIMIT_AMMOUNT;
    }

    public double getTotalAmmount() {
        return getAmmount() + getBrandRateService();
    }

    //~ Static Fields ................................................................................................................................

    private static final double MAX_LIMIT_AMMOUNT = 1000;
    private static final double MIN_LIMIT_AMMOUNT = 0;
}  // end class Operation
