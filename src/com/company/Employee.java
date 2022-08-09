package com.company;

public class Employee extends Person{

    private double salary;
    private double advanceOfWage;
    private boolean student;

    public Employee(String name, double salary, double advanceOfWage, boolean student) {
        super(name);
        setAdvanceOfWage(advanceOfWage);
        setSalary(salary);
        this.student = student;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary <= 0) throw new UnsupportedOperationException("Vyplata musi byt pozitivni.");
        this.salary = salary;
    }

    public double getAdvanceOfWage() {
        return advanceOfWage;
    }


    public void setAdvanceOfWage(double advanceOfWage) {
        if(advanceOfWage < 0) throw new UnsupportedOperationException("Záloha musí byt pozitivní nebo 0.");
        this.advanceOfWage = advanceOfWage;
    }

    public boolean isStudent() {
        return student;
    }

    public double getSocialInsurance(){
        double ret;
        if(!isStudent())
            ret = getSalary() - (getSalary() * 0.935);
        else if((isStudent() && getSalary() > 10000))
            ret = getSalary() - (getSalary() *0.935);
        else ret = 0;
            return ret;
    }

    public double getHealthInsurance(){
        double ret;
        if(!isStudent() || (isStudent() && getSalary() > 10000))
        ret = getSalary() - (getSalary() * 0.955);
        else ret = 0;
        return ret;
    }

    public double getSalaryAfterTax(){
        double ret = getSalary() * 0.95;
        if(isStudent() == true) return getSalary() - ret;
        return  getSalary() - Utils.getTax(getSalary());
    }

    public double getExactSalary(){
        return getSalary() - getSalaryAfterTax() - getHealthInsurance() - getSocialInsurance();
    }

    public double getFinalSalary(){
        double ret = getExactSalary() - getAdvanceOfWage();
        if(ret < 0) throw new UnsupportedOperationException("Zaloha činí víc, než výdělek po zdanění.");
        return ret;
    }


    @Override
    public String toString() {
        if(getSalary() < getAdvanceOfWage())
            throw new UnsupportedOperationException("Nelze vyplatit vetši zalohu nez je vyplata");
       else if(isStudent() && getSalary() > 10000)
            return String.format("Zaměstnanec: %s,výplata:%.2f KČ,vyplacená záloha:%.2f KČ, student:%b.Jelikož je osoba student a výdělek je nad 10000 KČ, odvody jsou následující: %nSociální pojištění:%.2f KČ, zdravotní pojištění:%.2f KČ, daň:%.2f KČ%n",super.toString(),getFinalSalary(), getAdvanceOfWage(),isStudent(),getSocialInsurance(), getHealthInsurance(),getSalaryAfterTax());
        else
            return String.format("Zaměstnanec: %s,výplata:%.2f KČ,vyplacená záloha:%.2f KČ, student:%b. %nSociální pojištění:%.2f KČ, zdravotní pojištění:%.2f KČ, daň:%.2f KČ%n",super.toString(),getFinalSalary(), getAdvanceOfWage(),isStudent(),getSocialInsurance(), getHealthInsurance(),getSalaryAfterTax());
    }
}
