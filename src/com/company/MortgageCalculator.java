package com.company;

public class MortgageCalculator {
    // FINAL FIELDS
    private final static int MONTH_IN_YEAR = 12;
    private final static int PERCENT = 100;

    // PRIVATE FIELDS
    private int principal;
    private float annualInterest;
    private int years;

    //  CONSTRUCTOR FOR DECLARING FIELDS
    public MortgageCalculator(int principal, float annualInterest, int years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    // THIS METHOD GENERATES MORTGAGE
    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        int noOfPayments = getNoOfPayments();
        double mortgage = principal * monthlyInterest * Math.pow(1 + monthlyInterest, noOfPayments)
                / (Math.pow(1 + monthlyInterest, noOfPayments) - 1);

        return mortgage;
    }

    // THIS METHOD GENERATES BALANCE.
    public double calculateBalance(int noOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        int noOfPayments = getNoOfPayments();
        double balance = principal * (Math.pow(1 + monthlyInterest, noOfPayments) -
                Math.pow(1 + monthlyInterest, noOfPaymentsMade)) /
                (Math.pow(1 + monthlyInterest, noOfPayments) - 1);

        return balance;
    }

    // THIS METHOD RETURNS AN ARRAY OF CALCULATED BALANCE.
    public double[] getRemainingBalances() {
        var balances = new double[getNoOfPayments()];
        for (int month = 1; month <= balances.length ; month++) {
            balances[month -1] = calculateBalance(month);
        }
        return balances;
    }

    // GETTERS
    private float getMonthlyInterest(){
        return annualInterest / MONTH_IN_YEAR / PERCENT;
    }

    private int getNoOfPayments() {
        return years * MONTH_IN_YEAR;
    }

}
