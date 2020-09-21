package com.company;

public class Main {

    public static void main(String[] args) {

        // READING INPUT FROM USER USING CONSOLE CLASS
        int principal = (int) Console.readNumber("Principal(1K-1M): ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: " , 1, 30);
        int years =(int) Console.readNumber("Period(Years): " , 1 ,30);

        //CREATING OBJECTS
        var calculator = new MortgageCalculator(principal , annualInterest , years);
        var report = new MortgageReport(calculator);

        // PRINTS OUTPUT TO THE CONSOLE
        report.printMortgage();
        report.printPaymentSchedule();
    }

}



