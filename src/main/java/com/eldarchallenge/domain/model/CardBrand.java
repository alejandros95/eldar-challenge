package com.eldarchallenge.domain.model;

import com.sun.istack.NotNull;

import static com.eldarchallenge.domain.model.Utils.getActualArgentineDay;
import static com.eldarchallenge.domain.model.Utils.getActualArgentineMonth;
import static com.eldarchallenge.domain.model.Utils.getActualArgentineYear;

public interface CardBrand {

    //~ Instance Fields ..............................................................................................................................

    double MAX_SERVICE_RATE = 5.0;
    double MIN_SERVICE_RATE = 0.3;

    //~ Methods ......................................................................................................................................

    String getBrandName();
    double getServiceRate();

    //~ Enums ........................................................................................................................................

    enum Amex implements CardBrand {
        INSTANCE("AMEX");

        @NotNull private final String label;

        Amex(String label) {
            this.label = label;
        }

        @Override public String getBrandName() {
            return label;
        }

        public Amex getInstance() {
            return INSTANCE;
        }

        @Override public double getServiceRate() {
            final double month = getActualArgentineMonth();
            final double rate  = month * 0.1;
            return rate < MIN_SERVICE_RATE ? MIN_SERVICE_RATE : Utils.roundToOneDecimal(rate);
        }
    }

    enum Visa implements CardBrand {
        INSTANCE("VISA");

        @NotNull private final String label;

        Visa(String label) {
            this.label = label;
        }

        @Override public String getBrandName() {
            return label;
        }

        public Visa getInstance() {
            return INSTANCE;
        }

        @Override public double getServiceRate() {
            final double month = getActualArgentineMonth();
            final double year  = getActualArgentineYear();
            final double rate  = year / month;
            return rate < MIN_SERVICE_RATE ? MIN_SERVICE_RATE : rate > MAX_SERVICE_RATE ? MAX_SERVICE_RATE : Utils.roundToOneDecimal(rate);
        }
    }

    enum Nara implements CardBrand {
        INSTANCE("NARA");

        @NotNull private final String label;

        Nara(String label) {
            this.label = label;
        }

        @Override public String getBrandName() {
            return label;
        }

        public Nara getInstance() {
            return INSTANCE;
        }

        @Override public double getServiceRate() {
            final double day  = getActualArgentineDay();
            final double rate = day * 0.5;
            return rate > MAX_SERVICE_RATE ? MAX_SERVICE_RATE : Utils.roundToOneDecimal(rate);
        }
    }
}  // end interface CardBrand
