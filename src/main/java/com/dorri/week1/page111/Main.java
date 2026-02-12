package com.dorri.week1.page111;

public class Main {
    public static void main(String[] args) {
        TimeMaturityAccount timeMaturityAccount =
                new TimeMaturityAccount(100,
                        0.02,
                        false,
                        0.01);

        System.out.println(timeMaturityAccount);
        System.out.println("Amount= " + timeMaturityAccount.withdrawFunds(10));
        System.out.println(timeMaturityAccount);
    }
}
