package com.dorri.week1.page159;

public class Psychiatrist {

    public void examine(Moody moody) {
        moody.queryMood();
    }

    public void observe(Sad sad) {
        sad.cry();
    }

    public void observe(Happy happy) {
        happy.laugh();
    }
}
