package com.company;

public class Utils {

    public static double getTax(double salary) {
        double salaryAfterTax = 0;
        if (salary < 30000) salaryAfterTax = salary * 0.85;
        else salaryAfterTax = salary * 0.8;
        return salaryAfterTax;
    }
}

