package com.eldarchallenge;

import java.time.YearMonth;

import com.eldarchallenge.domain.model.CardBrand;
import com.eldarchallenge.domain.model.CreditCard;
import com.eldarchallenge.domain.model.Operation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EldarchallengeApplication {

    //~ Methods ......................................................................................................................................

    public static void main(String[] args) {
        SpringApplication.run(EldarchallengeApplication.class, args);
        try {
            final CreditCard visaCard = new CreditCard("Juan Perez", 987654321, YearMonth.of(2026, 6), CardBrand.Visa.INSTANCE.getInstance());
            final CreditCard amexCard = new CreditCard("Pedro Sanchez", 123456789, YearMonth.of(2021, 10), CardBrand.Amex.INSTANCE.getInstance());
            final CreditCard naraCard = new CreditCard("Marco Solis", 123454321, YearMonth.of(2019, 6), CardBrand.Nara.INSTANCE.getInstance());

            printCards(visaCard, amexCard, naraCard);

            System.out.println();
            printOperations(visaCard, amexCard, naraCard);

            System.out.println();
            printComparations(visaCard, amexCard, naraCard);

            System.out.println();
            printRateOperations(visaCard);
        }
        catch (final RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printCards(CreditCard visaCard, CreditCard amexCard, CreditCard naraCard) {
        System.out.println("** TARJETAS **");
        System.out.println(visaCard.toString() + "\n");
        System.out.println(amexCard.toString() + "\n");
        System.out.println(naraCard.toString() + "\n");
    }

    private static void printComparations(CreditCard visaCard, CreditCard amexCard, CreditCard naraCard) {
        System.out.println("** COMPARACIONES **");
        System.out.println("Tarjeta Visa es igual a tarjeta Visa?");
        System.out.println(visaCard.equals(visaCard) ? "S??" : "No");

        System.out.println("Tarjeta Visa es igual a tarjeta Amex?");
        System.out.println(visaCard.equals(amexCard) ? "S??" : "No");

        System.out.println("Tarjeta Visa es igual a tarjeta Nara?");
        System.out.println(visaCard.equals(naraCard) ? "S??" : "No");

        System.out.println("Tarjeta Amex es igual a tarjeta Amex?");
        System.out.println(amexCard.equals(amexCard) ? "S??" : "No");

        System.out.println("Tarjeta Amex es igual a tarjeta Nara?");
        System.out.println(amexCard.equals(naraCard) ? "S??" : "No");

        System.out.println("Tarjeta Nara es igual a tarjeta Nara?");
        System.out.println(naraCard.equals(naraCard) ? "S??" : "No");
    }

    private static void printOperations(CreditCard visaCard, CreditCard amexCard, CreditCard naraCard) {
        System.out.println("** OPERACIONES **");
        final Operation visaOperation = new Operation(900, visaCard);
        System.out.println("Operaci??n con tarjeta Visa monto 900");
        System.out.println("Es v??lida la tarjeta?");
        System.out.println(visaCard.isValid() ? "S??" : "No");
        System.out.println("Es v??lida la operaci??n?");
        System.out.println(visaOperation.isValid() ? "S??" : "No");

        final Operation amexOperation = new Operation(1200, amexCard);
        System.out.println("\nOperaci??n con tarjeta Amex monto 1200");
        System.out.println("Es v??lida la tarjeta?");
        System.out.println(amexCard.isValid() ? "S??" : "No");
        System.out.println("Es v??lida la operaci??n?");
        System.out.println(amexOperation.isValid() ? "S??" : "No");

        final Operation naraOperation = new Operation(700, naraCard);
        System.out.println("\nOperaci??n con tarjeta Nara monto 700");
        System.out.println("Es v??lida la tarjeta?");
        System.out.println(naraCard.isValid() ? "S??" : "No");
        System.out.println("Es v??lida la operaci??n?");
        System.out.println(naraOperation.isValid() ? "S??" : "No");
    }

    private static void printRateOperations(CreditCard visaCard) {
        System.out.println("** TASAS DE OPERACIONES **");
        final Operation visaOp = new Operation(900, visaCard);
        System.out.println("Operaci??n con tarjeta Visa monto 900");
        System.out.println("Es v??lida la tarjeta?");
        System.out.println(visaCard.isValid() ? "S??" : "No");
        System.out.println("Es v??lida la operaci??n?");
        System.out.println(visaOp.isValid() ? "S??" : "No");
        System.out.println("Es v??lida la operaci??n?");
        System.out.println("Monto de la operaci??n:");
        System.out.println(visaOp.getAmmount());
        System.out.println("Tasa de inter??s del servicio la tarjeta:");
        System.out.println(visaCard.getCardBrand().getServiceRate());
        System.out.println("Valor del inter??s del monto:");
        System.out.println(visaOp.getBrandRateService());
        System.out.println("Monto total de la operaci??n:");
        System.out.println(visaOp.getTotalAmmount());
    }
}  // end class EldarchallengeApplication
