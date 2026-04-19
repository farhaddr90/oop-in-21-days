package com.dorri;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {

    private final DeckPile cards;
    private final List<Player> players = new ArrayList<>();
    private int index = 0;

    public Dealer(String name, Hand hand, DeckPile cards) {
        super(name, hand);
        this.cards = cards;
    }

    @Override
    protected boolean hit() {
        return false;
    }

    public void play(Player player) {
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void hit(Player player) {
    }

    public void passTurn() {
    }

    public void deal() {
        for (Player player : players) {
            player.addCard(cards.dealUp());
        }
        addCard(cards.dealUp());
        for (Player player : players) {
            player.addCard(cards.dealUp());
        }
        addCard(cards.dealDown());
    }
}
