package com.dorri;

public class HumanPlayer extends Player {

    private static String MSG = "[H]it or [S]tand %s ?";
    private static String HIT = "H";
    private static String STNAD = "S";
    private static String DEFAULT = "invalid";

    public HumanPlayer(String name, Hand hand) {
        super(name, hand);
    }

    @Override
    protected boolean hit() {
        while (true) {
            Console console = Console.INSTANCE;
            console.printMessage(MSG.formatted(getName()));
            String input = console.readInput();
            if (input.equals(HIT)) {
                return true;
            } else if (input.equals(STNAD)) {
                return false;
            } else {
                console.printMessage(DEFAULT);
            }
        }
    }
}
