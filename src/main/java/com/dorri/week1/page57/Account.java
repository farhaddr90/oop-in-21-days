package com.dorri.week1.page57;

import com.dorri.week1.page111.BankAccount;

public class Account {
    private double balance;

    public Account() {
    }

    public Account(double initialDeposit) {
        balance = initialDeposit;
    }

    public double getBalance() {
        return balance;
    }

    public void depositFunds(double funds) {
        balance += funds;
    }

    public void withdrawFunds(double funds) {
        if (funds > balance) {
            balance = 0;
            return;
        }
        balance -= funds;
    }

}
