package com.company;

import java.text.NumberFormat;

public class MortgageReport {

    // FIELDS
    private final NumberFormat currency;
    private  MortgageCalculator calculator;

    // CONSTRUCTOR FOR DECLARING FIELDS
    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    // PRINTS MORTGAGE
    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        String mortgageFormatted = currency.format(mortgage);
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    // PRINTS PAYMENT SCHEDULE
    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }
}
