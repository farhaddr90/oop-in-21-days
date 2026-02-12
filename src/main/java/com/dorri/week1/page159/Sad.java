package com.dorri.week1.page159;

public class Sad extends Moody {
    @Override
    protected String getMood() {
        return "sad";
    }

    public void cry() {
        System.out.println("'wah hoo boo' 'boo boo' 'weep'");
    }
}
