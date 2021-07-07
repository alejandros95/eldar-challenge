package com.eldarchallenge.domain.model;

import com.sun.istack.NotNull;

public enum Messages {

    //~ Enum constants ...............................................................................................................................

    INVALID_BRAND_NAME("Operación no soportada, nombre de marca inválido"),
    AMMOUNT_EXCEEDS_LIMIT("El monto ingresado supera el límite por operación (1000)"), NULL_CARDHOLDER("Titular de la tarjeta es nulo"),
    WRONG_CARDNUMBER("Número de la tarjeta es incorrecto"), NULL_EXPDATE("Fecha de vencimiento de tarjeta es nulo"),
    NULL_CARDBRAND("Marca de la tarjeta es nulo"), WRONG_AMMOUNT("Monto de la operación incorrecto"),
    NULL_CREDITCARD("Los datos de la tarjeta de crédito son nulos"), EXPIRED_CARD("La tarjeta se encuentra vencida");

    //~ Instance Fields ..............................................................................................................................

    @NotNull private final String label;

    //~ Constructors .................................................................................................................................

    Messages(String label) {
        this.label = label;
    }

    //~ Methods ......................................................................................................................................

    public String getLabel() {
        return label;
    }
}
