package com.dorri;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, Hand hand) {
        super(name, hand);
    }

    @Override
    protected boolean hit() {
        return false;
    }
}
