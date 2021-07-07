package com.eldarchallenge.domain.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public interface Utils {

    //~ Instance Fields ..............................................................................................................................

    String ARGENTINA_ZONE_ID = "America/Argentina/Buenos_Aires";

    //~ Methods ......................................................................................................................................

    static double roundToOneDecimal(double value) {
        final DecimalFormat df = new DecimalFormat("#.#");
        return Double.valueOf(df.format(value));
    }
    static double getActualArgentineDay() {
        return Double.valueOf(getActualArgentineLocalDate().format(DateTimeFormatter.ofPattern("dd")));
    }
    static LocalDate getActualArgentineLocalDate() {
        return LocalDate.now(ZoneId.of(ARGENTINA_ZONE_ID));
    }
    static double getActualArgentineMonth() {
        return Double.valueOf(getActualArgentineLocalDate().format(DateTimeFormatter.ofPattern("MM")));
    }
    static double getActualArgentineYear() {
        return Double.valueOf(getActualArgentineLocalDate().format(DateTimeFormatter.ofPattern("yy")));
    }
}
