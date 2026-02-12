package com.dorri.week1.page159;

public class Main {
    public static void main(String[] args) {
        Psychiatrist psychiatrist = new Psychiatrist();
        Sad sad = new Sad();
        Happy happy = new Happy();

        psychiatrist.examine(sad);
        psychiatrist.observe(sad);

        psychiatrist.examine(happy);
        psychiatrist.observe(happy);
    }
}
