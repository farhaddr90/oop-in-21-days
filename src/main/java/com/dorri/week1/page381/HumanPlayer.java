package com.dorri.week1.page381;

public class HumanPlayer extends Player {

    private final static String MSG = "[H]it or [S]tand";
    private final static String HIT = "H";
    private final static String STAND = "S";
    private final static String DEFAULT = "invalid";

    public HumanPlayer(String name, Hand hand) {
        super(name, hand);
    }

    @Override
    protected boolean hit() {
        while (true) {
            Console.INSTANCE.printMessage(getName() + ": " + MSG);
            String response = Console.INSTANCE.readInput(DEFAULT);
            if (response.equals(HIT)) {
                return true;
            } else if (response.equals(STAND)) {
                return false;
            }
        }
    }
}
