package com.dorri.week1.page111;

public class CheckingAccount extends BankAccount {

    private int monthlyQuota;
    private double balance;

    public CheckingAccount() {
    }

    public CheckingAccount(double balance, int monthlyQuota) {
        super(balance);
        this.monthlyQuota = monthlyQuota;
    }

    public void applyQuota(double quota) {

    }
}
