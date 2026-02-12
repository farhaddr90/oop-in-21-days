package com.dorri.week1.page111;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        setInterestRate(interestRate);
    }

    public void addInterest() {
        double interest = getBalance() * getInterestRate();
        setBalance(getBalance() + interest);
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
               "interestRate=" + interestRate +
               "} " + super.toString();
    }
}
