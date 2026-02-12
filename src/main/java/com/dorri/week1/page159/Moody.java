package com.dorri.week1.page159;

public abstract class Moody {
    protected abstract String getMood();
    public void queryMood(){
        System.out.println("I feel " + getMood() + " today");
    }
}
