package com.dorri.week1.page159;

public class Happy extends Moody {
    @Override
    protected String getMood() {
        return "happy";
    }

    public void laugh() {
        System.out.println("'ha ha ha'");
    }
}
