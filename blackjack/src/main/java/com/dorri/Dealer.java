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
        return getHand().total() < 17;
    }

    public void play(Player player) {
        while (
                !player.isBusted() &&
                !player.isBlackjack() &&
                player.hit()
        ) {
            hit(player);
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void hit(Player player) {
        player.addCard(cards.dealUp());
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

    public void startGame() {
        for (Player player : players) {
            play(player);
        }
        getHand().turnOver();
        notifyListeners();
        while (hit()) {
            addCard(cards.dealUp());
        }
    }
}
