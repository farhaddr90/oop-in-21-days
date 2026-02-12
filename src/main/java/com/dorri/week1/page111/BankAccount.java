package com.dorri.week1.page111;

public class BankAccount {
    private double balance;

    public BankAccount() {
    }

    public BankAccount(double initDeposit) {
        setBalance(initDeposit);
    }

    public void depositFunds(double amount) {
        setBalance(getBalance() + amount);
    }

    protected void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public double withdrawFunds(double amount) {
        if (amount > getBalance()) {
            amount = getBalance();
        }
        setBalance(getBalance() - amount);
        return amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
               "balance=" + balance +
               '}';
    }
}
