package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void getSalary() {

    }

    @Test
    void getAdvanceOfWage() {
    }

    @Test
    void getSocialInsurance() {
        Employee e = new Employee("fs",30000,1000,false);
        assertEquals(1950,e.getSocialInsurance());
    }

    @Test
    void getHealthInsuranceRight() {
        try{
            Employee e = new Employee("fs",30000,1000,false);
            assertEquals(1350,e.getHealthInsurance());
        }catch (Exception e){

        }
    }

    @Test
    void getHealtInsuranceZero(){
        try{
            Employee e = new Employee("Petr",10000,1000,true);
            assertEquals(0,e.getHealthInsurance());
        }catch (NullPointerException e){

        }

    }

    @Test
    void getSalaryAfterTax() {
    }

    @Test
    void getExactSalary() {
    }

    @Test
    void getFinalSalary() {
    }
}