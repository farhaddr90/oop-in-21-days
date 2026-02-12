package com.dorri.week1.page111;

public class TimeMaturityAccount extends SavingsAccount {

    private boolean mature;
    private double feeRate;

    public TimeMaturityAccount(double initialBalance,
                               double interestRate,
                               boolean mature,
                               double feeRate
    ) {
        super(initialBalance, interestRate);
        this.mature = mature;
        setFeeRate(feeRate);
    }

    public boolean isMature() {
        return mature;
    }

    public void mature() {
        this.mature = true;
    }

    public double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(double feeRate) {
        this.feeRate = feeRate;
    }

    @Override
    public double withdrawFunds(double amount) {
        super.withdrawFunds(amount);
        if (!isMature()) {
            double charge = amount * feeRate;
            amount = amount - charge;
        }
        return amount;
    }

    @Override
    public String toString() {
        return "TimeMaturityAccount{" +
               "mature=" + mature +
               ", feeRate=" + feeRate +
               "} " + super.toString();
    }
}
